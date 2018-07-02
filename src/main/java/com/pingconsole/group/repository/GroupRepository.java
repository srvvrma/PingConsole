package com.pingconsole.group.repository;

import com.pingconsole.group.domain.PingGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<PingGroup, Long>{
    public PingGroup findByName(String name);

    public PingGroup findByCode(String code);

    public PingGroup getOne(Long id);

}