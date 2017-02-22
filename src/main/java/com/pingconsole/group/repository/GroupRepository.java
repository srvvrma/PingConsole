package com.pingconsole.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pingconsole.group.domain.PingGroup;

public interface GroupRepository extends JpaRepository<PingGroup, Long>{
  public PingGroup findByName(String name);
  public PingGroup findByCode(String code);
  public PingGroup findById(Long id);
  
}