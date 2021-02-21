package org.izce.petclinic.repositories;

import java.util.List;

import org.izce.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long>{
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameContainingIgnoreCase(String lastName);
}
