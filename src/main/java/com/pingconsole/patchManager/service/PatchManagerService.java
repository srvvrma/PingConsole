package com.pingconsole.patchManager.service;

import java.util.List;

import com.pingconsole.patchManager.domain.PatchManager;
import com.pingconsole.patchManager.domain.PatchManagerDTO;

public interface PatchManagerService {
	
	public void savePatchManager(PatchManagerDTO patchManagerDTO);

	public PatchManager parseToPatchManager(PatchManagerDTO patchManagerDTO);

	public PatchManagerDTO getPatchManagerDTOById(Long id);

	public PatchManagerDTO parseToPatchManager(PatchManager patchManager);

	public List<PatchManagerDTO> findAllDTOs();

	public Long executeIndexingTaskFor(Long id);
	

}
