package org.izce.petclinic.services.map;

import org.izce.petclinic.model.Pet;
import org.izce.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
	
	@Override
	public Pet save(Pet pet) {
		map.put(pet.getId(), pet);
		return pet;
	}
	
}
