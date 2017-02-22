package com.pingconsole.environment.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingconsole.environment.domain.Environment;
import com.pingconsole.environment.domain.EnvironmentDTO;
import com.pingconsole.environment.repository.EnvironmentRepository;

@Service
@Transactional
public class EnvironmentServiceImpl implements EnvironmentService{

	
	@Autowired
	private EnvironmentRepository environmentRepository;
	
	@Override
	public List<EnvironmentDTO> getAllEnvironment() {
		List<Environment> environments = environmentRepository.findAll();
		List<EnvironmentDTO> environmentDTOs = new ArrayList<>();
		EnvironmentDTO environmentDTO =null;
		for (Environment environment : environments) {
			environmentDTO = EnvironmentDTO.parse(environment);
			environmentDTOs.add(environmentDTO);
		}
		return environmentDTOs;
	}

}
