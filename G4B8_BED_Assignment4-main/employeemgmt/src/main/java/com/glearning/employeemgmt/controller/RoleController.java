package com.glearning.employeemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.employeemgmt.entity.Role;
import com.glearning.employeemgmt.service.RoleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	@ApiOperation(value = "Get Roles", notes = "API to get all available roles")
	@GetMapping("/getAllRoles")
	public List<Role> getAllRoles() {
		return roleService.findAllRoles();
	}

	@ApiOperation(value = "Create Role", notes = "API to create a role")
	@PostMapping("/createRole")
	public String createRole(Role role) {
		return roleService.createRole(role);
	}

	@ApiOperation(value = "Delete Role", notes = "API to delete a role by ID")
	@DeleteMapping("/deleteRole")
	public String deleteRole(Long roleId) {
		return roleService.deleteRole(roleId);
	}

}
