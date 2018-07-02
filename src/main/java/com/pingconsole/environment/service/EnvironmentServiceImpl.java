package com.pingconsole.environment.service;

import com.pingconsole.environment.domain.Environment;
import com.pingconsole.environment.domain.EnvironmentDTO;
import com.pingconsole.environment.repository.EnvironmentRepository;
import com.pingconsole.group.domain.PingGroup;
import com.pingconsole.group.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EnvironmentServiceImpl implements EnvironmentService {
	
	@Value("${server.address}")
    private String serverAddress;

    @Value("${server.port}")
    private String serverPort;

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
		for (Long id : environmentDTO.getGroupId()) {
            groupList.add(groupRepository.getOne(id));
		}
		environment.setGroupList(groupList);
		if (!environmentDTO.getEnvironmentType().equalsIgnoreCase(EnvironmentDTO.INT)) {
			List<Environment> environmentList = new ArrayList<>();
			for (Long id : environmentDTO.getIntergrationEnvironmentDTOs()) {
                environmentList.add(environmentRepository.getOne(id));
			}
			environment.setIntergrationEnvironments(environmentList);
		}
		environment.setSyncUrl(serverAddress+":"+serverPort+"/api/environment/getStatus/");
		environmentRepository.save(environment);

	}

	@Override
	public EnvironmentDTO getEnvironmentById(Long id) {
        EnvironmentDTO environmentDTO = EnvironmentDTO.parse(environmentRepository.getOne(id));
		return environmentDTO;
	}

	@Override
	public List<Environment> getAllIntergration() {
		List<Environment> environments = environmentRepository.findByEnvironmentType(EnvironmentDTO.INT);
		return environments;
	}

  @Override
  public Environment getById(Long environmentId) {
      return environmentRepository.getOne(environmentId);
  }

@Override
public List<Environment> getAllEnvironments() {
	return environmentRepository.findAll();
}

}
