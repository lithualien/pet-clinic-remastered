package com.github.lithualien.petclinicremastered.repositories;

import com.github.lithualien.petclinicremastered.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
