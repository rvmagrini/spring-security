package com.rvmagrini.springsecurity.security;

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
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/", "index", "/css/*", "/js/*").permitAll()
			.antMatchers("/school/**").hasRole(ApplicationUserRole.STUDENT.name())
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {

		UserDetails johnMayallUser = User.builder()
			.username("mayall")
			.password(passwordEncoder.encode("mayall123"))
			.roles(ApplicationUserRole.STUDENT.name()) 
			.build();
		
		UserDetails principalUser = User.builder()
				.username("principal")
				.password(passwordEncoder.encode("principal123"))
				.roles(ApplicationUserRole.ADMIN.name()) 
				.build();
		
		UserDetails traineeUser = User.builder()
				.username("trainee")
				.password(passwordEncoder.encode("trainee123"))
				.roles(ApplicationUserRole.ADMINTRAINEE.name()) 
				.build();
		
		return new InMemoryUserDetailsManager(
				johnMayallUser, 
				principalUser,
				traineeUser);
		
	}
	
	
	
	

}
