package org.izce.petclinic.services.map;

import org.izce.petclinic.model.Owner;
import org.izce.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
	
	@Override
	public Owner save(Owner owner) {
		map.put(owner.getId(), owner);
		return owner;
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return map.values().stream().filter(owner -> owner.getLastName().equals(lastName)).findFirst().orElse(null);
	}
	
}
