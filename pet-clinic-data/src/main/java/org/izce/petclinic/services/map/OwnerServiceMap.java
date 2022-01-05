package org.izce.petclinic.services.map;

import java.util.List;

import org.izce.petclinic.model.Owner;
import org.izce.petclinic.model.Pet;
import org.izce.petclinic.services.OwnerService;
import org.izce.petclinic.services.PetService;
import org.izce.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({ "default", "map" })
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {
	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner findByLastName(String lastName) {
		return map.values().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst()
				.orElse(null);
	}

	@Override
	public Owner save(Owner owner) {
		if (owner == null) {
			return null;
		}

		if (owner.getPets() != null) {
			owner.getPets().forEach(pet -> {
				if (pet.getPetType() == null) {
					throw new IllegalArgumentException("Pet Type is required!");
				}

				if (pet.getPetType().getId() == null) {
					pet.setPetType(petTypeService.save(pet.getPetType()));
				}

				if (pet.getId() == null) {
					Pet savedPet = petService.save(pet);
					pet.setId(savedPet.getId());
				}
			});
		}
		return super.save(owner);
	}

	@Override
	public List<Owner> findAllByLastNameContainingIgnoreCase(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
