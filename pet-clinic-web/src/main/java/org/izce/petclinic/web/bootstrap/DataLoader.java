package org.izce.petclinic.web.bootstrap;

import org.izce.petclinic.data.model.Owner;
import org.izce.petclinic.data.model.Vet;
import org.izce.petclinic.data.services.OwnerService;
import org.izce.petclinic.data.services.VetService;
import org.izce.petclinic.data.services.map.OwnerServiceMap;
import org.izce.petclinic.data.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader() {
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Ayşe");
		owner1.setLastName("Bacı");
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Fatma");
		owner2.setLastName("Hanım");
		ownerService.save(owner2);
		
		System.out.println("Loaded owners!");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Hasan");
		vet1.setLastName("Bakan");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Tarkan");
		vet2.setLastName("Yakan");
		vetService.save(vet2);
		System.out.println("Loaded vets!");
	}

}
