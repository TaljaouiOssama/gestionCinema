package com.ossama.gestioncinema.repositories;

import com.ossama.gestioncinema.dao.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SessionRepository extends JpaRepository<Session,Integer> {
}
