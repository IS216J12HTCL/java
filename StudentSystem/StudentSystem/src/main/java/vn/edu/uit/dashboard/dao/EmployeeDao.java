package vn.edu.uit.dashboard.dao;

import java.util.Date;
import java.util.List;


import vn.edu.uit.dashboard.model.User;

public interface EmployeeDao {
User findOne(int id);
	
User findByEmail(String email);
	
User findByPhone(String phone);
    
    void create(User entity);

    void update(User entity);

    void delete(User entity);
	List<User> findAll();

	
	List<User> findAllByDate( Date fromDate, Date toDate);

}
