package com.pingconsole.patch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.patch.dto.PingResultDTO;

public interface PingResultRepository extends JpaRepository<PingResultDTO, Long>{
  
  public PingResultDTO findById(Long id);

}
