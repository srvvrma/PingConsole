package com.pingconsole.environmentUser.service;

import com.pingconsole.environment.domain.Environment;
import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.environmentUser.domain.EnvironmentUser;
import com.pingconsole.environmentUser.domain.EnvironmentUserDTO;
import com.pingconsole.environmentUser.repository.EnvironmentUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EnvironmentUserServiceImpl implements EnvironmentUserService {
	@Autowired
	private EnvironmentUserRepository environmentUserRepository;
	
	@Autowired
	private EnvironmentService environmentService;

	@Override
	public EnvironmentUserDTO getEnvironmentUserById(Long id) {
		// TODO Auto-generated method stub
        return EnvironmentUserDTO.parse(environmentUserRepository.getOne(id));
	}

	@Override
	public void saveOrUpdateEnvironmentUser(EnvironmentUserDTO environmentUserDTO) {
		EnvironmentUser environmentUser = null;
		if (environmentUserDTO.getId() != null) {
            environmentUser = environmentUserRepository.getOne(environmentUserDTO.getId());
		} else {
			environmentUser = new EnvironmentUser();
		}
		parse(environmentUser, environmentUserDTO);
		environmentUserRepository.save(environmentUser);
	}

	private void parse(EnvironmentUser environmentUser, EnvironmentUserDTO environmentUserDTO) {
		environmentUser.setUserName(environmentUserDTO.getUserName());
		environmentUser.setPassword(environmentUserDTO.getPassword());
		List<Environment> environmentList = new ArrayList<>();
		if(!CollectionUtils.isEmpty(environmentUserDTO.getEnvironmentIds())){
			for (Long id : environmentUserDTO.getEnvironmentIds()) {
				environmentList.add(environmentService.getById(id));
			}
		}
		environmentUser.setEnvironments(environmentList);
	}

	@Override
	public List<EnvironmentUserDTO> getAllEnvironmentUsers() {
		List<EnvironmentUser> environmentUsers = environmentUserRepository.findAll();
		List<EnvironmentUserDTO> environmentUserDTOs = new ArrayList<>();
		EnvironmentUserDTO environmentUserDTO = null;
		for (EnvironmentUser environmentUser : environmentUsers) {
			environmentUserDTO = new EnvironmentUserDTO();
			parse(environmentUserDTO,environmentUser);
			environmentUserDTOs.add(environmentUserDTO);
		}
		return environmentUserDTOs;
	}

	private void parse(EnvironmentUserDTO environmentUserDTO, EnvironmentUser environmentUser) {
		environmentUserDTO.setId(environmentUser.getId());
		environmentUserDTO.setUserName(environmentUser.getUserName());
		environmentUserDTO.setPassword(environmentUser.getPassword());
	}

}
