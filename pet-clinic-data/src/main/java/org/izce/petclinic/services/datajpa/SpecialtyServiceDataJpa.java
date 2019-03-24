package org.izce.petclinic.services.datajpa;

import java.util.HashSet;
import java.util.Set;

import org.izce.petclinic.model.Specialty;
import org.izce.petclinic.repositories.SpecialtyRepository;
import org.izce.petclinic.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class SpecialtyServiceDataJpa implements SpecialtyService {
	private final SpecialtyRepository specialtyRepository;

	@Autowired
	public SpecialtyServiceDataJpa(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Specialty save(Specialty specialty) {
		return specialtyRepository.save(specialty);
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialtys = new HashSet<>();
		specialtyRepository.findAll().forEach(specialtys::add);
		;
		return specialtys;
	}

	@Override
	public Specialty findById(Long id) {
		return specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Specialty object) {
		specialtyRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
	}
}
