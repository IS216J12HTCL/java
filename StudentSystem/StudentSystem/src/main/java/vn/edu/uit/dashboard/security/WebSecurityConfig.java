
package vn.edu.uit.dashboard.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
/**
 * @author kelvin
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		        .passwordEncoder(new ShaPasswordEncoder(256));
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
			.antMatchers("/dang-nhap", "/quen-mat-khau", "/reset-password", "/login", "/static/**", "/api/**").permitAll()
			.antMatchers("/**").authenticated()
		.and()
			.formLogin().loginPage("/dang-nhap")
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/")
			.failureUrl("/dang-nhap?error")
			.usernameParameter("username").passwordParameter("password")				
		.and()
			.logout()
				.logoutSuccessUrl("/dang-nhap?logout")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
		.and()
			.exceptionHandling().accessDeniedPage("/dang-nhap?error");
		
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/static/**", "/upload/**");
	}
}