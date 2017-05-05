package com.pingconsole.environmentUser.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingconsole.environmentUser.domain.EnvironmentUserDTO;
import com.pingconsole.environmentUser.repository.EnvironmentUserRepository;

@Service
@Transactional
public class EnvironmentUserServiceImpl implements EnvironmentUserService{
  @Autowired
  private EnvironmentUserRepository environmentUserRepository;

  @Override
  public EnvironmentUserDTO getEnvironmentUserById(Long id) {
    // TODO Auto-generated method stub
    return EnvironmentUserDTO.parse(environmentUserRepository.findById(id));
  }

}
