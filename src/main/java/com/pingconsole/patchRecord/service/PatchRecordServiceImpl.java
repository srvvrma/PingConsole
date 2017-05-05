package com.pingconsole.patchRecord.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pingconsole.auth.model.User;
import com.pingconsole.dashboard.service.UserDashboardService;
import com.pingconsole.environment.service.EnvironmentService;
import com.pingconsole.patchRecord.domain.PatchRecord;
import com.pingconsole.patchRecord.domain.PatchRecordDTO;
import com.pingconsole.patchRecord.repository.PatchRecordRepository;

@Service
public class PatchRecordServiceImpl implements PatchRecordService {

  @Autowired
  private PatchRecordRepository patchRecordRepository;

  @Autowired
  private EnvironmentService environmentService;

  @Autowired
  private UserDashboardService userDashboardService;
  
  @Override
  public void savePatchRecord(PatchRecordDTO patchRecordDTO) {
    if (patchRecordDTO.getId() == null) {
      patchRecordRepository.save(parse(patchRecordDTO));
    } else {

    }
  }

  private PatchRecord parse(PatchRecordDTO patchRecordDTO) {
    PatchRecord patchRecord = new PatchRecord();
    patchRecord.setName(patchRecordDTO.getName());
    patchRecord.setCreateDate(patchRecordDTO.getCreateDate());
    patchRecord.setDescription(patchRecordDTO.getDescription());
    patchRecord.setEnvironment(environmentService.getById(patchRecordDTO.getEnvironment()));
    List<User> userList = new ArrayList<>();
    for (Long userId : patchRecordDTO.getUsers()) {
      userList.add(userDashboardService.getUserByUserId(userId));
    }
    patchRecord.setUsers(userList);
    patchRecord.setPatchData(patchRecordDTO.getPatchData());
    patchRecord.setJiraId(patchRecordDTO.getJiraId());
    return patchRecord;
  }

  @Override
  public void removePatchRecord(Long id) {
    patchRecordRepository.delete(id);
  }

  @Override
  public List<PatchRecordDTO> findAllDTOs() {
    List<PatchRecordDTO> patchRecordDTOs = new ArrayList<>();
    PatchRecordDTO patchRecordDTO = null;
    for(PatchRecord patchRecord : patchRecordRepository.findAll()){
      patchRecordDTO = parse(patchRecord);
      patchRecordDTOs.add(patchRecordDTO);
    }
    return patchRecordDTOs;
  }

  private PatchRecordDTO parse(PatchRecord patchRecord) {
    PatchRecordDTO patchRecordDTO = new PatchRecordDTO();
    patchRecordDTO.setId(patchRecord.getId());
    patchRecordDTO.setCreateDate(patchRecord.getCreateDate());
    patchRecordDTO.setDescription(patchRecord.getDescription());
    patchRecordDTO.setEnvironment(patchRecord.getEnvironment().getId());
    patchRecordDTO.setJiraId(patchRecord.getJiraId());
    patchRecordDTO.setName(patchRecord.getName());
    return patchRecordDTO;
  }

}
