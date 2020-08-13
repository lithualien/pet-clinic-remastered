package com.github.lithualien.petclinicremastered.services.map;

import com.github.lithualien.petclinicremastered.model.Owner;
import com.github.lithualien.petclinicremastered.model.Pet;
import com.github.lithualien.petclinicremastered.services.OwnerService;
import com.github.lithualien.petclinicremastered.services.PetService;
import com.github.lithualien.petclinicremastered.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        if(object == null) {
            throw new RuntimeException("Object is null.");
        }

        if(object.getPets() != null) {
            object
                    .getPets()
                    .forEach(pet -> {
                        if(pet.getPetType() != null) {
                            if(pet.getPetType().getId() == null) {
                                pet.setPetType(petTypeService.save(pet.getPetType()));
                            }
                        }
                        if(pet.getId() == null) {
                            Pet savePet = petService.save(pet);
                            pet.setId(savePet.getId());
                        }
                    });
        }

        return super.save(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
