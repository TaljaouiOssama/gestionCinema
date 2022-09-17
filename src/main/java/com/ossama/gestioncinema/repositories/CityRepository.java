package com.ossama.gestioncinema.repositories;

import com.ossama.gestioncinema.dao.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CityRepository extends JpaRepository<City,Integer> {
}
