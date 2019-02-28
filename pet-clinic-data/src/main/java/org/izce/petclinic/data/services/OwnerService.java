package org.izce.petclinic.data.services;

import org.izce.petclinic.data.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	Owner findByLastName(String lastName);
}
