package com.pingconsole.environment.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingconsole.environment.domain.Environment;
import com.pingconsole.environment.domain.EnvironmentDTO;
import com.pingconsole.environment.repository.EnvironmentRepository;
import com.pingconsole.group.domain.PingGroup;
import com.pingconsole.group.repository.GroupRepository;

@Service
@Transactional
public class EnvironmentServiceImpl implements EnvironmentService {


  @Autowired
  private EnvironmentRepository environmentRepository;
  
  @Autowired
  private GroupRepository groupRepository;
  
  
  @Override
  public List<EnvironmentDTO> getAllEnvironment() {
    List<Environment> environments = environmentRepository.findAll();
    List<EnvironmentDTO> environmentDTOs = new ArrayList<>();
    EnvironmentDTO environmentDTO = null;
    for (Environment environment : environments) {
      environmentDTO = EnvironmentDTO.parse(environment);
      environmentDTOs.add(environmentDTO);
    }
    return environmentDTOs;
  }

  @Override
  public void createOrUpdate(EnvironmentDTO environmentDTO) {
    Environment environment = EnvironmentDTO.parse(environmentDTO);
    List<PingGroup> groupList = new ArrayList<>();
    for(Long id : environmentDTO.getGroupId()){
      groupList.add(groupRepository.findById(id));
    }
    environment.setGroupList(groupList);
    environmentRepository.save(environment);

  }

  @Override
  public EnvironmentDTO getEnvironmentById(Long id) {
    EnvironmentDTO environmentDTO = EnvironmentDTO.parse(environmentRepository.findById(id));
    return environmentDTO;
  }

}
