package com.ossama.gestioncinema.repositories;

import com.ossama.gestioncinema.dao.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
