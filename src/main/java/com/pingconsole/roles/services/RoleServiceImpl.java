package com.pingconsole.roles.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingconsole.auth.model.Role;
import com.pingconsole.auth.repository.RoleRepository;
import com.pingconsole.roles.dto.RoleDTO;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public List<RoleDTO> getAllRoles() {
    List<Role> roles = roleRepository.findAll();
    List<RoleDTO> roleDTOs = new ArrayList<>();
    for (Role role : roles) {
      roleDTOs.add(role.convertToDto());
    }
    return roleDTOs;
  }


}
