package com.pingconsole.auth.repository;

import com.pingconsole.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

    public Role getOne(Long id);
}
