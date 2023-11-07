package com.glearning.employeemgmt.service;

import java.util.List;

import com.glearning.employeemgmt.entity.Role;

public interface RoleService {
	List<Role> findAllRoles();

	String createRole(Role role);

	Role findRoleById(Long roleId);

	String deleteRole(Long roleId);

}
