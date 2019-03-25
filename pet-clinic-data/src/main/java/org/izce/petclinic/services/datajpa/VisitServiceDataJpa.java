package org.izce.petclinic.services.datajpa;

import java.util.HashSet;
import java.util.Set;

import org.izce.petclinic.model.Visit;
import org.izce.petclinic.repositories.VisitRepository;
import org.izce.petclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitServiceDataJpa implements VisitService {
	private final VisitRepository visitRepository;

	@Autowired
	public VisitServiceDataJpa(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit save(Visit visit) {
		return visitRepository.save(visit);
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		;
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}
}
