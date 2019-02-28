package org.izce.petclinic.services;

import org.izce.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	Owner findByLastName(String lastName);
}
