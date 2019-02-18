package org.izce.petclinic.data.services;

import java.util.Set;

import org.izce.petclinic.data.model.Owner;

public interface OwnerInterface {
	Owner findByLastName(String lastName);

	Owner findById(Long Id);

	Owner save(Owner owner);

	Set<Owner> findAll();
}
