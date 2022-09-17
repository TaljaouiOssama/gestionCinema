package com.ossama.gestioncinema.repositories;

import com.ossama.gestioncinema.dao.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
