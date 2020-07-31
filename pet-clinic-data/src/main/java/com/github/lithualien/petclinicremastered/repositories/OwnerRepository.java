package com.github.lithualien.petclinicremastered.repositories;

import com.github.lithualien.petclinicremastered.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
