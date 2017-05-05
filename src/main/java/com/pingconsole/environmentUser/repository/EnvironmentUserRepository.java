package com.pingconsole.environmentUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.environmentUser.domain.EnvironmentUser;

public interface EnvironmentUserRepository extends JpaRepository<EnvironmentUser, Long>{
  
  public EnvironmentUser findById(Long id);

}
