package vn.edu.uit.dashboard.dao;

import java.util.Date;
import java.util.List;

import vn.edu.uit.dashboard.model.Nguoidung;


public interface NguoiDungDao {
	Nguoidung findByCode(String code);
	
	Nguoidung findByEmail(String email);
	
	Nguoidung findByPhone(String phone);
    
    void create(Nguoidung entity);

    void update(Nguoidung entity);

    void delete(Nguoidung entity);
   
	List<Nguoidung> findAll();

	List<Nguoidung> findAllByDate( Date fromDate, Date toDate);

}
