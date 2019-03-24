package org.izce.petclinic.repositories;

import org.izce.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	Owner findByLastName(String lastName);
}
