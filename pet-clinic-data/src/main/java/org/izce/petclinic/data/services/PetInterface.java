package org.izce.petclinic.data.services;

import java.util.Set;

import org.izce.petclinic.data.model.Pet;

public interface PetInterface {

	Pet findById(Long Id);

	Pet save(Pet pet);

	Set<Pet> findAll();
}
