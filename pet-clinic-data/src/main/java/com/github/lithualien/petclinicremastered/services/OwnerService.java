package com.github.lithualien.petclinicremastered.services;

import com.github.lithualien.petclinicremastered.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
