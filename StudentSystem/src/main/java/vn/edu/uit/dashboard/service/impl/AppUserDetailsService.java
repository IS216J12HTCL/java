package vn.edu.uit.dashboard.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import vn.edu.uit.dashboard.model.CustomUser;
import vn.edu.uit.dashboard.model.Nguoidung;
import vn.edu.uit.dashboard.repository.AdminRepository;



/**
 * @author Dell
 */
@Component
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private AdminRepository userRepository;

    @Override
    public CustomUser loadUserByUsername(String s) throws UsernameNotFoundException {
    	Nguoidung user = userRepository.findByUsername(s);
        
        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

    	EmployeePrincipal principal = new EmployeePrincipal(user);
    	
     	
      List<GrantedAuthority> authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority(user.getLoainguoidung().getMaLoaiND()));

        CustomUser userDetails = new CustomUser(
        		user.getMaND();
        		user.getMatKhau();
        		user.getTenDNhap();
        		principal.getAuthorities());

        return userDetails;
    }
}
