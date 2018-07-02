package com.pingconsole.environment.repository;

import com.pingconsole.environment.domain.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
@RepositoryRestResource(collectionResourceRel = "environment", path = "data")
public interface EnvironmentRepository extends JpaRepository<Environment, Long>{

    public Environment getOne(Long id);

    public List<Environment> findByEnvironmentTypeIn(Collection<String> environmentTypes);

    public List<Environment> findByEnvironmentType(String environmentType);

}
