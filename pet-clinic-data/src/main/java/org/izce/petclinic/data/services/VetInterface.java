package org.izce.petclinic.data.services;

import java.util.Set;

import org.izce.petclinic.data.model.Vet;

public interface VetInterface {

	Vet findById(Long Id);

	Vet save(Vet vet);

	Set<Vet> findAll();
}
