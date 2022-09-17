package com.ossama.gestioncinema.repositories;

import com.ossama.gestioncinema.dao.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeatRepository extends JpaRepository<Seat,Integer> {
}
