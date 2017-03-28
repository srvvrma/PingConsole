package com.pingconsole.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	public Role findById(Long id);
}
