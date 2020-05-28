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
        owner.setFirstName("Michael");
        owner.setLastName("Meston");
        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glenanne");
        ownerService.save(owner1);

        System.out.println("loaded owner....");

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Jordan");
        vet1.setLastName("Smith");
        vetService.save(vet1);

        System.out.println("loaded vets....");
    }
}
