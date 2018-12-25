package vn.edu.uit.dashboard.repository;

import org.springframework.data.repository.CrudRepository;
import vn.edu.uit.dashboard.model.User;

/**
 * @author Minh Anh
 */
public interface AdminRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
