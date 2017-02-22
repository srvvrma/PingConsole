package com.pingconsole.environment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.environment.domain.Environment;

public interface EnvironmentRepository extends JpaRepository<Environment, Long>{
	
	public Environment findById(Long id);

}
