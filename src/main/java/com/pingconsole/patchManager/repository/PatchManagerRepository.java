package com.pingconsole.patchManager.repository;

import com.pingconsole.patchManager.domain.PatchManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatchManagerRepository extends JpaRepository<PatchManager, Long>{
    public PatchManager getOne(Long id);
}
