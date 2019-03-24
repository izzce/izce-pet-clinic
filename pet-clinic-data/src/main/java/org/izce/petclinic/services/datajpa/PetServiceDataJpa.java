package org.izce.petclinic.services.datajpa;

import java.util.HashSet;
import java.util.Set;

import org.izce.petclinic.model.Pet;
import org.izce.petclinic.repositories.PetRepository;
import org.izce.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetServiceDataJpa implements PetService {
	private final PetRepository petRepository;

	@Autowired
	public PetServiceDataJpa(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Pet save(Pet pet) {
		return petRepository.save(pet);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		;
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}
}
