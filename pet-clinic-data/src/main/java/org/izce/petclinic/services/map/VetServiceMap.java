package org.izce.petclinic.services.map;

import org.izce.petclinic.model.Vet;
import org.izce.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
	
}
