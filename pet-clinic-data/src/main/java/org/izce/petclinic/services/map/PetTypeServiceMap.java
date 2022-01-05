package org.izce.petclinic.services.map;

import org.izce.petclinic.model.PetType;
import org.izce.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMap extends AbstractMapService<PetType> implements PetTypeService {

}
