package vn.edu.uit.dashboard.dao;

import java.util.List;

import vn.edu.uit.dashboard.model.Bangdiem;


public interface BangDiemDao {
Bangdiem findOne(int id);
	
	
	Bangdiem findByEmail(String email);
	
	Bangdiem findByPhone(String phone);
    
    void create(Bangdiem entity);

    void update(Bangdiem entity);

    void delete(Bangdiem entity);
	List<Bangdiem> findAll();


}
