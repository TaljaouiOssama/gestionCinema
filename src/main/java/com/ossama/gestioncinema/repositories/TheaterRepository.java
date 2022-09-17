package com.ossama.gestioncinema.repositories;

import com.ossama.gestioncinema.dao.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TheaterRepository extends JpaRepository<Theater,Integer> {
}
