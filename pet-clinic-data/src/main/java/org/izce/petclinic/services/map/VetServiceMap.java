package org.izce.petclinic.services.map;

import org.izce.petclinic.model.Specialty;
import org.izce.petclinic.model.Vet;
import org.izce.petclinic.services.SpecialtyService;
import org.izce.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
	private final SpecialtyService specialtyService;

	public VetServiceMap(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}

	@Override
	public Vet save(Vet vet) {
		if (vet.getSpecialties().size() > 0) {
			vet.getSpecialties().forEach(specialty -> {
				if (specialty.getId() == null) {
					Specialty savedSpecialty = specialtyService.save(specialty);
					specialty.setId(savedSpecialty.getId());
				}
			});
		}
		return super.save(vet);
	}
}
