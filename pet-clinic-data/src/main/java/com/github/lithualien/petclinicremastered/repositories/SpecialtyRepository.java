package com.github.lithualien.petclinicremastered.repositories;

import com.github.lithualien.petclinicremastered.model.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
