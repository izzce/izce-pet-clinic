package org.izce.petclinic.bootstrap;

import org.izce.petclinic.model.Owner;
import org.izce.petclinic.model.PetType;
import org.izce.petclinic.model.Vet;
import org.izce.petclinic.services.OwnerService;
import org.izce.petclinic.services.PetTypeService;
import org.izce.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Ayşe");
		owner1.setLastName("Bacı");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fatma");
		owner2.setLastName("Hanım");
		ownerService.save(owner2);
		
		System.out.println("Loaded owners!");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Hasan");
		vet1.setLastName("Bakan");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Tarkan");
		vet2.setLastName("Yakan");
		vetService.save(vet2);
		
		System.out.println("Loaded vets!");
	}

}
