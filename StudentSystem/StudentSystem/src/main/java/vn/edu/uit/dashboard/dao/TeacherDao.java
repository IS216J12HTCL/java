package vn.edu.uit.dashboard.dao;

import java.util.Date;
import java.util.List;

import vn.edu.uit.dashboard.model.Teacher;

public interface TeacherDao {
	Teacher findOne(int id);
	
	Teacher findByEmail(String email);
		
	Teacher findByPhone(String phone);
	    
	    void create(Teacher entity);

	    void update(Teacher entity);

	    void delete(Teacher entity);
		List<Teacher> findAll();

		
		List<Teacher> findAllByDate( Date fromDate, Date toDate);

}
