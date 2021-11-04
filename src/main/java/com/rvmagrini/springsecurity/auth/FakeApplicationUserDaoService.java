package com.rvmagrini.springsecurity.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.rvmagrini.springsecurity.security.ApplicationUserRole;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {
	
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	

	@Override
	public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
		return getApplicationUsers()
				.stream()
				.filter(applicationUser -> username.equals(applicationUser.getUsername()))
				.findFirst();
	}
	
	private List<ApplicationUser> getApplicationUsers() {
		List<ApplicationUser> applicationUsers = Lists.newArrayList(
				new ApplicationUser(
						"mayall", 
						passwordEncoder.encode("mayall123"), 
						ApplicationUserRole.STUDENT.getGrantedAuthorities(), 
						true, 
						true, 
						true, 
						true),
				
				new ApplicationUser(
						"nolen", 
						passwordEncoder.encode("nolen123"), 
						ApplicationUserRole.STUDENT.getGrantedAuthorities(), 
						true, 
						true, 
						true, 
						true),
				
				new ApplicationUser(
						"cale", 
						passwordEncoder.encode("cale123"), 
						ApplicationUserRole.STUDENT.getGrantedAuthorities(), 
						true, 
						true, 
						true, 
						true),
				
				new ApplicationUser(
						"trainee", 
						passwordEncoder.encode("trainee123"), 
						ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(), 
						true, 
						true, 
						true, 
						true),
				
				new ApplicationUser(
						"principal", 
						passwordEncoder.encode("principal123"), 
						ApplicationUserRole.ADMIN.getGrantedAuthorities(), 
						true, 
						true, 
						true, 
						true)
				);
		
		return applicationUsers;
	}

}