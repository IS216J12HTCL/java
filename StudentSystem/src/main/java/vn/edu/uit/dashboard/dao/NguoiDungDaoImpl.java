package vn.edu.uit.dashboard.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vn.edu.uit.dashboard.model.Nguoidung;
@Transactional
@Service("nguoiDungDao")
@Repository("nguoiDungDao")
public class NguoiDungDaoImpl  extends AbstractDao<Integer, Nguoidung> implements NguoiDungDao {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public Nguoidung findByCode(String code) {
		return (Nguoidung) sessionFactory.getCurrentSession().createCriteria(Nguoidung.class)
				.add(Restrictions.eq("code", code)).uniqueResult();
	}

	@Override
	public Nguoidung findByEmail(String email) {
		return (Nguoidung) sessionFactory.getCurrentSession().createCriteria(Nguoidung.class)
				.add(Restrictions.eq("email", email)).uniqueResult();
	}

	@Override
	public Nguoidung findByPhone(String phone) {
		return (Nguoidung) sessionFactory.getCurrentSession().createCriteria(Nguoidung.class)
				.add(Restrictions.eq("phone", phone)).uniqueResult();
	}

	@Override
	public void create(Nguoidung entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(entity);
	}

	@Override
	public void update(Nguoidung entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public void delete(Nguoidung entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}

	@Override
	public List<Nguoidung> findAll() {

		return null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Nguoidung> findAllByDate( Date fromDate, Date toDate) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Nguoidung.class)
				.addOrder(Property.forName("createdAt").asc());
		
		if(fromDate != null) {
			criteria.add(Restrictions.ge("createdAt", fromDate));
		}
		
		if(toDate != null) {
			criteria.add(Restrictions.le("createdAt", toDate));
		}
		
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return criteria.list();
	}

}
