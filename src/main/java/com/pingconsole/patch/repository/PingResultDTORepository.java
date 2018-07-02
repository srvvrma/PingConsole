package com.pingconsole.patch.repository;

import com.pingconsole.patch.dto.PingResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PingResultDTORepository extends JpaRepository<PingResultDTO, Long>{

    public PingResultDTO getOne(Long id);

}
