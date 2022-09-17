package com.ossama.gestioncinema.repositories;

import com.ossama.gestioncinema.dao.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
