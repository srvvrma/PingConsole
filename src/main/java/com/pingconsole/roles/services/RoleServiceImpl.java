package com.pingconsole.roles.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingconsole.auth.model.Privilege;
import com.pingconsole.auth.model.Role;
import com.pingconsole.auth.repository.PrivilageRepository;
import com.pingconsole.auth.repository.RoleRepository;
import com.pingconsole.roles.dto.RoleDTO;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PrivilageRepository privilageRepository;

  @Override
  public List<RoleDTO> getAllRoles() {
    List<Role> roles = roleRepository.findAll();
    List<RoleDTO> roleDTOs = new ArrayList<>();
    for (Role role : roles) {
      roleDTOs.add(role.convertToDto());
    }
    return roleDTOs;
  }

  @Override
  public void createUpdate(RoleDTO roleDTO) {
    Role role = null;
    if (roleDTO.getId() == null) {
      role = new Role();
      role.setName(roleDTO.getName());
      role.setCode(roleDTO.getCode());
      Set<Privilege> privileges = new HashSet<>();
      for (Long privilegeId : roleDTO.getPrivileges()) {
        privileges.add(privilageRepository.findById(privilegeId));
      }
      role.setPrivileges(privileges);
    } else {
      role = roleRepository.findById(roleDTO.getId());
      role.setName(roleDTO.getName());
      role.setCode(roleDTO.getCode());
      Set<Privilege> privileges = new HashSet<>();
      for (Long privilegeId : roleDTO.getPrivileges()) {
        privileges.add(privilageRepository.findById(privilegeId));
      }
      role.setPrivileges(privileges);

    }
    roleRepository.save(role);

  }

  @Override
  public RoleDTO findRoleById(Long id) {
    RoleDTO roleDTO = roleRepository.findById(id).convertToDto();
    return roleDTO;
  }

}
