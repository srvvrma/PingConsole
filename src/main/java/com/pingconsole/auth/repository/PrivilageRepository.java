package com.pingconsole.auth.repository;

import com.pingconsole.auth.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilageRepository extends JpaRepository<Privilege, Long>{

	public Privilege getOne(Long id);
}

