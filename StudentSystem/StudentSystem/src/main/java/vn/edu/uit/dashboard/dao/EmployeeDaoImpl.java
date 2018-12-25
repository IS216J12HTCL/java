package vn.edu.uit.dashboard.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.edu.uit.dashboard.model.User;






@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, User> implements EmployeeDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User findOne(int id) {
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

	

	@Override
	public User findByEmail(String email) {
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("email", email)).uniqueResult();
	}

	@Override
	public User findByPhone(String phone) {
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("phone", phone)).uniqueResult();
	}

	@Override
	public void create(User entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.persist(entity);
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}

	@Override
	public List<User> findAll() {

		return null;
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllByDate( Date fromDate, Date toDate) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(User.class)
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