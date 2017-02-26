package com.pingconsole.environment.service;

import java.util.List;

import com.pingconsole.environment.domain.EnvironmentDTO;

public interface EnvironmentService {

  public List<EnvironmentDTO> getAllEnvironment();

  public void createOrUpdate(EnvironmentDTO environmentDTO);

  public EnvironmentDTO getEnvironmentById(Long id);

}
