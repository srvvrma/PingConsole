package com.pingconsole.patch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.patch.dto.PingResult;

public interface PingResultRepository  extends JpaRepository<PingResult, Long>{
  
  public PingResult findByKeyId(Long keyId);

}
