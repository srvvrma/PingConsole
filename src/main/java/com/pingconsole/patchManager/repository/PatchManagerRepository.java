package com.pingconsole.patchManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.patchManager.domain.PatchManager;


public interface PatchManagerRepository extends JpaRepository<PatchManager, Long>{
	public PatchManager findById(Long id);
}
