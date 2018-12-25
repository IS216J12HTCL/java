package vn.edu.uit.dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import vn.edu.uit.dashboard.model.Nguoidung;

/**
 * @author Minh Anh
 */
public interface AdminRepository extends CrudRepository<Nguoidung, Long> {
	Nguoidung findByUsername(String username);
}
