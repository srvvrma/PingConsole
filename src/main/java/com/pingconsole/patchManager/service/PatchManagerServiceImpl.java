package com.pingconsole.patchManager.service;

import com.pingconsole.environment.domain.Environment;
import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.patch.service.FileDirectoryService;
import com.pingconsole.patchManager.domain.PatchManager;
import com.pingconsole.patchManager.domain.PatchManagerDTO;
import com.pingconsole.patchManager.repository.PatchManagerRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatchManagerServiceImpl implements PatchManagerService {

	@Autowired
	private PatchManagerRepository patchManagerRepository;

	@Autowired
	private EnvironmentService environmentService;

	@Autowired
	private FileDirectoryService fileDirectoryService;

	@Override
	public void savePatchManager(PatchManagerDTO patchManagerDTO) {
		PatchManager patchManager = parseToPatchManager(patchManagerDTO);
		patchManagerRepository.save(patchManager);
	}

	@Override
	public PatchManagerDTO getPatchManagerDTOById(Long id) {
        PatchManager patchManager = patchManagerRepository.getOne(id);
		return parseToPatchManager(patchManager);
	}

	@Override
	public PatchManager parseToPatchManager(PatchManagerDTO patchManagerDTO) {
		PatchManager patchManager = null;
		if (patchManagerDTO.getId() == null) {
			patchManager = new PatchManager();
		} else {
            patchManager = patchManagerRepository.getOne(patchManagerDTO.getId());
		}
		patchManager.setName(patchManagerDTO.getName());
		patchManager.setCode(patchManagerDTO.getCode());
		patchManager.setDescription(patchManagerDTO.getDescription());
		patchManager.setSvnLocation(patchManagerDTO.getSvnLocation());
		Environment environment = environmentService.getById(patchManagerDTO.getEnvironmentId());
		if (environment != null) {
			patchManager.setEnvironment(environment);
		}
		return patchManager;
	}

	@Override
	public PatchManagerDTO parseToPatchManager(PatchManager patchManager) {
		PatchManagerDTO patchManagerDTO = new PatchManagerDTO();
		patchManagerDTO.setId(patchManager.getId());
		patchManagerDTO.setName(patchManager.getName());
		patchManagerDTO.setCode(patchManager.getCode());
		patchManagerDTO.setDescription(patchManager.getDescription());
		patchManagerDTO.setSvnLocation(patchManager.getSvnLocation());
		if (patchManager.getEnvironment() != null) {
			patchManagerDTO.setEnvironmentId(patchManager.getEnvironment().getId());
		}
		return patchManagerDTO;
	}

	@Override
	public List<PatchManagerDTO> findAllDTOs() {
		List<PatchManager> patchManagers = patchManagerRepository.findAll();
		List<PatchManagerDTO> patchManagerDTOs = new ArrayList<>();
		for (PatchManager patchManager : patchManagers) {
			patchManagerDTOs.add(parseToPatchManager(patchManager));
		}
		return patchManagerDTOs;
	}

	@Override
	public Long executeIndexingTaskFor(Long id) {
        PatchManager patchManager = patchManagerRepository.getOne(id);
		Hibernate.initialize(patchManager.getEnvironment());
		Environment environment = patchManager.getEnvironment();
		fileDirectoryService.CopyWarFromSVN(environment.getEnvLogUrl(),22,environment.getEnvLogUser(),environment.getEnvLogPass(),environment.getEnvWar(),patchManager.getCode());
		try {
			return fileDirectoryService.Start(patchManager.getCode());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		return 0L;
	}

}
