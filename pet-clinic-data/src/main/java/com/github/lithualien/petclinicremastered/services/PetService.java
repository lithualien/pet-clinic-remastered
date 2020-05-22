package com.github.lithualien.petclinicremastered.services;

import com.github.lithualien.petclinicremastered.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
