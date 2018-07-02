package com.pingconsole.environmentUser.repository;

import com.pingconsole.environmentUser.domain.EnvironmentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvironmentUserRepository extends JpaRepository<EnvironmentUser, Long>{

    public EnvironmentUser getOne(Long id);

}
