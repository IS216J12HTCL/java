package vn.edu.uit.dashboard.dao;

import java.util.List;

import vn.edu.uit.dashboard.model.Student;

public interface StudentDao {
	
	Student create(Student entity);
	
	void update(Student entity);
	
	List<Student> findAll();
	
	Student findOne(int id);
}
