package com.github.lithualien.petclinicremastered.services;

import com.github.lithualien.petclinicremastered.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
