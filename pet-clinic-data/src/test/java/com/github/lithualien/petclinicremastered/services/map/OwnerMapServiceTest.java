package com.github.lithualien.petclinicremastered.services.map;

import com.github.lithualien.petclinicremastered.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;
    private final Long ownerId = 1L;
    private final String lastName = "Dominauskas";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(lastName);
        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long ownerId2 = 2L;
        Owner owner = new Owner();
        owner.setId(ownerId2);
        Owner savedOwner = ownerMapService.save(owner);

        assertEquals(ownerId2, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(new Owner());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void saveNull() {
        assertThrows(RuntimeException.class, () -> {
            ownerMapService.save(null);
        });
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner tomas = ownerMapService.findByLastName(lastName);
        assertNotNull(tomas);
        assertEquals(lastName, tomas.getLastName());
        assertEquals(1, tomas.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner tomas = ownerMapService.findByLastName("foo");
        assertNull(tomas);
    }
}