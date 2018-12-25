package vn.edu.uit.dashboard.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import vn.edu.uit.dashboard.model.Teacher;

@Transactional
@Service("teacherDao")
@Repository("teacherDao")
public class TeacherDaoImpl extends AbstractDao<Integer, Teacher> implements TeacherDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Teacher findOne(int id) {
		return (Teacher) sessionFactory.getCurrentSession().createCriteria(Teacher.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	

	@Override
	public Teacher findByEmail(String email) {
		return (Teacher) sessionFactory.getCurrentSession().createCriteria(Teacher.class)
				.add(Restrictions.eq("email", email)).uniqueResult();
	}

	@Override
	public Teacher findByPhone(String phone) {
		return (Teacher) sessionFactory.getCurrentSession().createCriteria(Teacher.class)
				.add(Restrictions.eq("phone", phone)).uniqueResult();
	}

	@Override
	public void create(Teacher entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(entity);
	}

	@Override
	public void update(Teacher entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public void delete(Teacher entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Teacher.class)
				.addOrder(Property.forName("id").desc());
				
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) ;
		return criteria.list();
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> findAllByDate( Date fromDate, Date toDate) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(Teacher.class)
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