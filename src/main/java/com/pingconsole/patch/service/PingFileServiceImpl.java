package com.pingconsole.patch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pingconsole.patch.dto.PingFile;
import com.pingconsole.patch.repository.PingFileRepository;

@Service
@Transactional
public class PingFileServiceImpl implements PingFileService {

  @Autowired
  private PingFileRepository pingFileRepository;

  @Override
  public int savePingFile(PingFile pingFile) {
    if (pingFile.getId() == 0) {
      pingFileRepository.save(pingFile);
      return 1;
    } else {
      pingFileRepository.save(pingFile);
      return 0;
    }
  }

  @Override
  public int updatePingFile(PingFile pingFile) {
    pingFileRepository.save(pingFile);
    return 0;
  }

}
