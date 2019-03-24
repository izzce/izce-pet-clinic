package org.izce.petclinic.services.datajpa;

import java.util.HashSet;
import java.util.Set;

import org.izce.petclinic.model.Vet;
import org.izce.petclinic.repositories.VetRepository;
import org.izce.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VetServiceDataJpa implements VetService {
	private final VetRepository vetRepository;

	@Autowired
	public VetServiceDataJpa(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Vet save(Vet vet) {
		return vetRepository.save(vet);
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		;
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}
}
