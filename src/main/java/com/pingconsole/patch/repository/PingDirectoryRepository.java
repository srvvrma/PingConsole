package com.pingconsole.patch.repository;

import com.pingconsole.patch.dto.PingDirectory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PingDirectoryRepository  extends JpaRepository<PingDirectory, Long>{

    Long deleteByPatchWarCode(String patchWarCode);


}
