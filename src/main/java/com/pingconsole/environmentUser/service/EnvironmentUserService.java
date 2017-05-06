package com.pingconsole.environmentUser.service;

import java.util.List;

import com.pingconsole.environmentUser.domain.EnvironmentUserDTO;

public interface EnvironmentUserService {

	public EnvironmentUserDTO getEnvironmentUserById(Long id);

	public void saveOrUpdateEnvironmentUser(EnvironmentUserDTO environmentUserDTO);

	public List<EnvironmentUserDTO> getAllEnvironmentUsers();

}
