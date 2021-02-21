package org.izce.petclinic.services;

import java.util.List;

import org.izce.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

	//List<Owner> findAllByLastNameLike(String lastName);
	List<Owner> findAllByLastNameContainingIgnoreCase(String lastName);
}
