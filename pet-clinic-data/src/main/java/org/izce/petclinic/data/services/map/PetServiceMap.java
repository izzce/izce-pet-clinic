package org.izce.petclinic.data.services.map;

import org.izce.petclinic.data.model.Pet;
import org.izce.petclinic.data.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
	
	@Override
	public Pet save(Pet pet) {
		map.put(pet.getId(), pet);
		return pet;
	}
	
}
