package com.github.lithualien.petclinicremastered.services;

import com.github.lithualien.petclinicremastered.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
