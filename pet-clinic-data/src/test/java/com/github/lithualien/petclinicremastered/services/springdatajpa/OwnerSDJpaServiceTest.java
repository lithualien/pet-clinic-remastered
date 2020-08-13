package com.github.lithualien.petclinicremastered.services.springdatajpa;

import com.github.lithualien.petclinicremastered.model.Owner;
import com.github.lithualien.petclinicremastered.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private static final String LAST_NAME = "foo";
    private static final Long OWNER_ID = 1L;

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerSDJpaService ownerSDJpaService;

    private Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = new Owner();
        returnedOwner.setId(OWNER_ID);
        returnedOwner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(Optional.of(returnedOwner));

        Owner owner = ownerSDJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());

    }

    @Test
    void findAll() {

        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(returnedOwner);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> ownersResults = ownerSDJpaService.findAll();
        assertNotNull(ownersResults);
        assertEquals(1, ownersResults.size());
        assertTrue(ownersResults.contains(returnedOwner));
    }

    @Test
    void findByIdWithData() {

        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnedOwner));

        Owner owner = ownerSDJpaService.findById(OWNER_ID);
        assertNotNull(owner);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void findByIdNoData() {
        Long id = 2L;
        assertNull(ownerSDJpaService.findById(id));
    }

    @Test
    void save() {
        Long id = 2L;
        Owner owner = new Owner();
        owner.setId(id);

        when(ownerRepository.save(any(Owner.class))).thenReturn(owner);

        Owner savedOwner = ownerSDJpaService.save(owner);

        assertNotNull(savedOwner);
        assertEquals(id, savedOwner.getId());

    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnedOwner);

        verify(ownerRepository).delete(any(Owner.class));
        Owner deletedOwner = ownerSDJpaService.findById(OWNER_ID);
        assertNull(deletedOwner);
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(OWNER_ID);
        verify(ownerRepository).deleteById(any(Long.class));

        Owner deletedOwner = ownerSDJpaService.findById(OWNER_ID);
        assertNull(deletedOwner);
    }
}