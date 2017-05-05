package com.pingconsole.patchRecord.service;

import java.util.List;

import com.pingconsole.patchRecord.domain.PatchRecordDTO;

public interface PatchRecordService {
	public void savePatchRecord(PatchRecordDTO patchRecordDTO);

  public void removePatchRecord(Long id);

  public List<PatchRecordDTO> findAllDTOs();
}
