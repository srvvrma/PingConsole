package com.pingconsole.patchRecord.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.patchRecord.domain.PatchRecord;

public interface PatchRecordRepository extends JpaRepository<PatchRecord, Long>{
	
	public PatchRecord findById(Long id);

}
