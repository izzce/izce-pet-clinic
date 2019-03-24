package org.izce.petclinic.services.datajpa;

import java.util.HashSet;
import java.util.Set;

import org.izce.petclinic.model.PetType;
import org.izce.petclinic.repositories.PetTypeRepository;
import org.izce.petclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetTypeServiceDataJpa implements PetTypeService {
	private final PetTypeRepository petTypeRepository;

	@Autowired
	public PetTypeServiceDataJpa(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType save(PetType petType) {
		return petTypeRepository.save(petType);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		;
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}
}
