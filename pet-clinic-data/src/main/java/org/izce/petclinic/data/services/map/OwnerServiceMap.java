package org.izce.petclinic.data.services.map;

import org.izce.petclinic.data.model.Owner;
import org.izce.petclinic.data.services.OwnerInterface;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerInterface {
	
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
