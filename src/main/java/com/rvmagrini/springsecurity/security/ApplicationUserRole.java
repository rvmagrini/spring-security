package com.rvmagrini.springsecurity.security;

import java.util.Set;

import com.google.common.collect.Sets;

public enum ApplicationUserRole {
	
	STUDENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(
			ApplicationUserPermission.STUDENT_WRITE,
			ApplicationUserPermission.STUDENT_READ,
			ApplicationUserPermission.COURSE_WRITE, 
			ApplicationUserPermission.COURSE_READ
			)),
	ADMINTRAINEE(Sets.newHashSet(
			ApplicationUserPermission.STUDENT_READ,
			ApplicationUserPermission.COURSE_READ
			));
	
	private final Set<ApplicationUserPermission> permissions;

	private ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}
	
}
