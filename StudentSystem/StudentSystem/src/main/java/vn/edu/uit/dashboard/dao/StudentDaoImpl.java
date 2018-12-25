package vn.edu.uit.dashboard.dao;

import java.util.List;
import java.util.Properties;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.edu.uit.dashboard.model.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Student create(Student entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
		return entity;
	}

	@Override
	public void update(Student entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Student.class)
				.addOrder(Property.forName("id").desc());
		return criteria.list();
	}

	@Override
	public Student findOne(int id) {
		// TODO Auto-generated method stub
		return (Student) sessionFactory.getCurrentSession()
				.createCriteria(Student.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
