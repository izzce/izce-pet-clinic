package org.izce.petclinic.services.map;

import org.izce.petclinic.model.Pet;
import org.izce.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
	
}
