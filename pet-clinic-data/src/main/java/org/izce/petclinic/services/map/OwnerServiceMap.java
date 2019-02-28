package org.izce.petclinic.services.map;

import org.izce.petclinic.model.Owner;
import org.izce.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findByLastName(String lastName) {
		return map.values().stream().filter(owner -> owner.getLastName().equals(lastName)).findFirst().orElse(null);
	}
	
}
