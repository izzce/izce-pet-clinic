package org.izce.petclinic.data.services.map;

import org.izce.petclinic.data.model.Vet;
import org.izce.petclinic.data.services.VetInterface;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetInterface {
	
	@Override
	public Vet save(Vet vet) {
		map.put(vet.getId(), vet);
		return vet;
	}
	
}
