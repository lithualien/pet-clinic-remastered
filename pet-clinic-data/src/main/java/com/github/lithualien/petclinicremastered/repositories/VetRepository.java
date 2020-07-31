package com.github.lithualien.petclinicremastered.repositories;

import com.github.lithualien.petclinicremastered.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
