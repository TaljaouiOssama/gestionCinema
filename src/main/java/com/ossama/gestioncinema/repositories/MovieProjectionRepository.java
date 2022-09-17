package com.ossama.gestioncinema.repositories;

import com.ossama.gestioncinema.dao.MovieProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MovieProjectionRepository extends JpaRepository<MovieProjection,Integer> {
}
