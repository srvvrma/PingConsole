package com.pingconsole.patch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.patch.dto.PingFile;

public interface PingFileRepository  extends JpaRepository<PingFile, Long>{
	
	Long deleteByPatchWarCode(String patchWarCode);

}
