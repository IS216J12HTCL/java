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

import vn.edu.uit.dashboard.model.EmployeePrincipal;
import vn.edu.uit.dashboard.model.User;
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
    	User user = userRepository.findByUsername(s);
        
        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

    	EmployeePrincipal principal = new EmployeePrincipal(user);
    	
     	
      List<GrantedAuthority> authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority(user.getUserRole().getRole()));

        CustomUser userDetails = new CustomUser(
        		user.getId(),
        		user.getUsername(),
        		user.getPassword(),
        		user.getUserRole().getId(),
        		user.getRoleEnumName(),
        		principal.getAuthorities());

        return userDetails;
    }
}
