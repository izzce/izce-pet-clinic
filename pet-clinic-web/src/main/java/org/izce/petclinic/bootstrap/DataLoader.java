package org.izce.petclinic.bootstrap;

import org.izce.petclinic.model.Owner;
import org.izce.petclinic.model.Vet;
import org.izce.petclinic.services.OwnerService;
import org.izce.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService vetService;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
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
