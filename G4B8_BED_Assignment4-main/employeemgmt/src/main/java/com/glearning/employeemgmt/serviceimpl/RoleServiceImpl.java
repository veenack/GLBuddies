package com.glearning.employeemgmt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.employeemgmt.entity.Role;
import com.glearning.employeemgmt.repository.RoleRepository;
import com.glearning.employeemgmt.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> findAllRoles() {
		List<Role> roles = roleRepository.findAll();
		return roles;
	}

	@Override
	public String createRole(Role role) {
		roleRepository.save(role);
		roleRepository.flush();
		return "Role saved";
	}

	@Override
	public Role findRoleById(Long roleId) {
		Role role = roleRepository.findById(roleId).get();
		return role;
	}

	@Override
	public String deleteRole(Long roleId) {
		roleRepository.deleteById(roleId);
		return "Deleted the Role of id "+roleId;
	}

}
