package com.github.lithualien.petclinicremastered.services.springdatajpa;

import com.github.lithualien.petclinicremastered.model.Speciality;
import com.github.lithualien.petclinicremastered.repositories.SpecialtyRepository;
import com.github.lithualien.petclinicremastered.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile({"springdatajpa"})
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialitySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialties = new HashSet<>();
        specialtyRepository
                .findAll()
                .forEach(specialties::add);
        return specialties;
    }

    @Override
    public Speciality findById(Long id) {
        return specialtyRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
