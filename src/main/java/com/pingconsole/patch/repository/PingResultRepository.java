package com.pingconsole.patch.repository;

import com.pingconsole.patch.dto.PingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PingResultRepository  extends JpaRepository<PingResult, Long>{

    public PingResult findByKeyId(Long keyId);

}
