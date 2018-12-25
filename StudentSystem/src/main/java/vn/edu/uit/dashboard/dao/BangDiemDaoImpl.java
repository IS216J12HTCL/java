package vn.edu.uit.dashboard.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vn.edu.uit.dashboard.model.Bangdiem;

@Transactional
@Service("bangDiemDao")
@Repository("bangDiemDao")
public class BangDiemDaoImpl extends AbstractDao<Integer, Bangdiem> implements BangDiemDao {
	@Autowired SessionFactory sessionFactory;

	@Override
	public Bangdiem findOne(int id) {
		return (Bangdiem) sessionFactory.getCurrentSession()
				.createCriteria(Bangdiem.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
	}
	
	@Override
	public Bangdiem findByEmail(String email) {
		return (Bangdiem) sessionFactory.getCurrentSession()
				.createCriteria(Bangdiem.class)
                .add(Restrictions.eq("email", email))
                .uniqueResult();
	}
	
	@Override
	public Bangdiem findByPhone(String phone) {
		return (Bangdiem) sessionFactory.getCurrentSession()
				.createCriteria(Bangdiem.class)
                .add(Restrictions.eq("phone", phone))
                .uniqueResult();
	}

	@Override
	public void create(Bangdiem entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        session.persist(entity);
	}

	@Override
	public void update(Bangdiem entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        session.update(entity);
	}
	
	@Override
	public void delete(Bangdiem entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Bangdiem> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Bangdiem.class)
				.addOrder(Property.forName("id").desc());
				
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) ;
		return criteria.list();
	}



}
