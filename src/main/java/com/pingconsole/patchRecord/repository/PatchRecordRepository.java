package com.pingconsole.patchRecord.repository;

import com.pingconsole.patchRecord.domain.PatchRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatchRecordRepository extends JpaRepository<PatchRecord, Long>{

    public PatchRecord getOne(Long id);

}
