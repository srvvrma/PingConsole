package com.pingconsole.environment.service;

import java.util.List;

import com.pingconsole.environment.domain.Environment;
import com.pingconsole.environment.domain.EnvironmentDTO;

public interface EnvironmentService {

	public List<EnvironmentDTO> getAllEnvironment();

	public void createOrUpdate(EnvironmentDTO environmentDTO);

	public EnvironmentDTO getEnvironmentById(Long id);

	public List<Environment> getAllIntergration();

	public Environment getById(Long environmentId);

	public List<Environment> getAllEnvironments();

}
