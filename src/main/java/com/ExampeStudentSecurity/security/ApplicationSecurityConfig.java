package com.ExampeStudentSecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PasswordEncoder passwordEncoder;
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/","index","/css/*","/js")
		.permitAll()
		.antMatchers("/api/**").hasRole(ApplicationUserRoles.STUDENT.name())
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	@Override
	@Bean
	public UserDetailsService userDetailsService() {
			UserDetails userMed = User.builder()
					.username("med")
					.password(passwordEncoder.encode("med"))
					.roles(ApplicationUserRoles.STUDENT.name())
					.build();
			
			UserDetails admin = User.builder()
					.username("admin")
					.password(passwordEncoder.encode("admin"))
					.roles(ApplicationUserRoles.ADMIN.name())
					.build();
			UserDetails tom = User.builder()
					.username("tom")
					.password(passwordEncoder.encode("tom"))
					.roles(ApplicationUserRoles.ADMINTRINEE.name())
					.build();
		
		return new  InMemoryUserDetailsManager(userMed,admin,tom);
	}
}
