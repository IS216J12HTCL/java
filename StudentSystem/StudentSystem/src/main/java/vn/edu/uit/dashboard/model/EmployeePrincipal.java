package vn.edu.uit.dashboard.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class EmployeePrincipal implements UserDetails{
	private static final long serialVersionUID = 1L;
	private User employee;
	 
	
	
	public EmployeePrincipal(User employee) {
		super();
		this.employee = employee;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        for (Privilege privilege : employee.getPrivileges()) {
	            authorities.add(new SimpleGrantedAuthority(privilege.getCode()));
	            
	        }
	        authorities.add(new SimpleGrantedAuthority(this.employee.getUserRole().getRole()));
	        return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return employee.getPassword();
	}

	@Override
	public String getUsername() {
		return employee.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}


	
}
