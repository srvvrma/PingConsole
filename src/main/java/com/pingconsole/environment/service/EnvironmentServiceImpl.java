package com.pingconsole.environment.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingconsole.environment.domain.EnvironementDTO;
import com.pingconsole.environment.domain.Environment;
import com.pingconsole.environment.repository.EnvironmentRepository;

@Service
@Transactional
public class EnvironmentServiceImpl implements EnvironmentService{

	
	@Autowired
	private EnvironmentRepository environmentRepository;
	
	@Override
	public List<EnvironementDTO> getAllEnvironment() {
		List<Environment> environments = environmentRepository.findAll();
		List<EnvironementDTO> environementDTOs = new ArrayList<>();
		EnvironementDTO environementDTO =null;
		for (Environment environement : environments) {
			environementDTO = EnvironementDTO.parse(environement);
			environementDTOs.add(environementDTO);
		}
		return environementDTOs;
	}

}
