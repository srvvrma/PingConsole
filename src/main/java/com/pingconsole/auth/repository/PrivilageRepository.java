package com.pingconsole.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.auth.model.Privilege;

public interface PrivilageRepository extends JpaRepository<Privilege, Long>{
}

