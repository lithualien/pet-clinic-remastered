package com.github.lithualien.petclinicremastered.bootstrap;

import com.github.lithualien.petclinicremastered.model.Owner;
import com.github.lithualien.petclinicremastered.model.Vet;
import com.github.lithualien.petclinicremastered.services.OwnerService;
import com.github.lithualien.petclinicremastered.services.VetService;
import com.github.lithualien.petclinicremastered.services.map.OwnerServiceMap;
import com.github.lithualien.petclinicremastered.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Michael");
        owner.setLastName("Meston");
        ownerService.save(owner);

        owner.setId(2L);
        owner.setFirstName("Fiona");
        owner.setLastName("Glenanne");
        ownerService.save(owner);

        System.out.println("loaded owner....");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vetService.save(vet);

        vet.setId(2L);
        vet.setFirstName("Jordan");
        vet.setLastName("Smith");
        vetService.save(vet);

        System.out.println("loaded vets....");
    }
}
