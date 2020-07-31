package com.github.lithualien.petclinicremastered.services.map;

import com.github.lithualien.petclinicremastered.model.Speciality;
import com.github.lithualien.petclinicremastered.model.Vet;
import com.github.lithualien.petclinicremastered.services.SpecialityService;
import com.github.lithualien.petclinicremastered.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialtyService;

    public VetMapService(SpecialityService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size() > 0) {
            object
                    .getSpecialities()
                    .forEach(specialty -> {
                        if(specialty.getId() == null) {
                            Speciality savedSpecialty = specialtyService.save(specialty);
                            specialty.setId(savedSpecialty.getId());
                        }
                    });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
