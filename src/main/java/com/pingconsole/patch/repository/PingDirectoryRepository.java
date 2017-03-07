package com.pingconsole.patch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.patch.dto.PingDirectory;

public interface PingDirectoryRepository  extends JpaRepository<PingDirectory, Long>{

}
