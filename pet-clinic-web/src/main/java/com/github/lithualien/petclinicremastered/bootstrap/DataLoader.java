package com.github.lithualien.petclinicremastered.bootstrap;

import com.github.lithualien.petclinicremastered.model.*;
import com.github.lithualien.petclinicremastered.services.OwnerService;
import com.github.lithualien.petclinicremastered.services.PetTypeService;
import com.github.lithualien.petclinicremastered.services.SpecialtyService;
import com.github.lithualien.petclinicremastered.services.VetService;
import jdk.nashorn.internal.runtime.Specialization;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner = new Owner();
        owner.setFirstName("Michael");
        owner.setLastName("Meston");
        owner.setAddress("123 Brickerel");
        owner.setCity("Miami");
        owner.setTelephone("123132121");

        Pet michaelPet = new Pet();
        michaelPet.setName("Dog");
        michaelPet.setOwner(owner);
        michaelPet.setPetType(savedDogPetType);
        michaelPet.setBirthDate(LocalDate.now());
        owner.getPets().add(michaelPet);
        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owner1.setLastName("Glenanne");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123132121");
        ownerService.save(owner1);

        Pet fionaPet = new Pet();
        fionaPet.setName("Cat");
        fionaPet.setOwner(owner1);
        fionaPet.setPetType(savedCatPetType);
        fionaPet.setBirthDate(LocalDate.now());
        owner.getPets().add(fionaPet);

        System.out.println("loaded owner....");

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vet.getSpecialties().add(savedRadiology);
        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Jordan");
        vet1.setLastName("Smith");
        vet1.getSpecialties().add(savedSurgery);
        vetService.save(vet1);

        System.out.println("loaded vets....");
    }
}
