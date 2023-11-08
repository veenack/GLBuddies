package com.glearning.employeemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glearning.employeemgmt.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
