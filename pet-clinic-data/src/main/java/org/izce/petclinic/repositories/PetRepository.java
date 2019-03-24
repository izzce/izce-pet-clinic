package org.izce.petclinic.repositories;

import org.izce.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
