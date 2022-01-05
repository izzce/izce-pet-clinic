package org.izce.petclinic.services.map;

import org.izce.petclinic.model.Visit;
import org.izce.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit> implements VisitService {
	
	@Override
	public Visit save(Visit visit) {
		if (visit.getPet() == null || visit.getPet().getId() == null 
				|| visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null) {
			throw new IllegalArgumentException("Invalid visit!");
		}
		
		return super.save(visit);
	}
}
