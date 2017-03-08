package com.pingconsole.environment.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.environment.domain.Environment;

public interface EnvironmentRepository extends JpaRepository<Environment, Long>{
	
	public Environment findById(Long id);
	
	public List<Environment> findByEnvironmentTypeIn(Collection<String> environmentTypes);
	
	public List<Environment> findByEnvironmentType(String environmentType);

}
