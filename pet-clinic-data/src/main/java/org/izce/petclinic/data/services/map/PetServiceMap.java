package org.izce.petclinic.data.services.map;

import org.izce.petclinic.data.model.Pet;
import org.izce.petclinic.data.services.PetInterface;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetInterface {
	
	@Override
	public Pet save(Pet pet) {
		map.put(pet.getId(), pet);
		return pet;
	}
	
}
