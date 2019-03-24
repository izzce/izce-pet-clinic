package org.izce.petclinic.services.datajpa;

import java.util.HashSet;
import java.util.Set;

import org.izce.petclinic.model.Owner;
import org.izce.petclinic.repositories.OwnerRepository;
import org.izce.petclinic.repositories.PetRepository;
import org.izce.petclinic.repositories.PetTypeRepository;
import org.izce.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class OwnerServiceDataJpa implements OwnerService {
	private final OwnerRepository ownerRepository;
	private final PetTypeRepository petTypeRepository;
	private final PetRepository petRepository;

	@Autowired
	public OwnerServiceDataJpa(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository,
			PetRepository petRepository) {
		this.ownerRepository = ownerRepository;
		this.petTypeRepository = petTypeRepository;
		this.petRepository = petRepository;
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public Owner save(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		;
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

}
