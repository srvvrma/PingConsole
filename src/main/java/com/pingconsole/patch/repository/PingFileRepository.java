package com.pingconsole.patch.repository;

import com.pingconsole.patch.dto.PingFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PingFileRepository  extends JpaRepository<PingFile, Long>{

    Long deleteByPatchWarCode(String patchWarCode);

}
