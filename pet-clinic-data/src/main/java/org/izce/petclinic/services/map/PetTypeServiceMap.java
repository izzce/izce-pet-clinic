package org.izce.petclinic.services.map;

import org.izce.petclinic.model.PetType;
import org.izce.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

}
