package org.izce.petclinic.bootstrap;

import java.time.LocalDate;

import org.izce.petclinic.model.Owner;
import org.izce.petclinic.model.Pet;
import org.izce.petclinic.model.PetType;
import org.izce.petclinic.model.Specialty;
import org.izce.petclinic.model.Vet;
import org.izce.petclinic.model.Visit;
import org.izce.petclinic.services.OwnerService;
import org.izce.petclinic.services.PetTypeService;
import org.izce.petclinic.services.SpecialtyService;
import org.izce.petclinic.services.VetService;
import org.izce.petclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;
	
	private boolean loaded = false;
	
	@Autowired
	public DataLoader(OwnerService ownerService, 
			VetService vetService, 
			PetTypeService petTypeService, 
			SpecialtyService specialtyService,
			VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		if (!loaded) {
			loadData();
			loaded = true;
		}
	}
	
	private void loadData() {
		
		// PET TYPES
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		// SPECIALTIES
		Specialty savedRadiology = specialtyService.save(new Specialty("radiology"));
		Specialty savedSurgery = specialtyService.save(new Specialty("surgery"));
		Specialty savedDentistry = specialtyService.save(new Specialty("dentistry"));
		
		Owner ownerProductOfBuilder = Owner.builder().id(1111L).firstName("first").lastName("last").address("adres").city("star").build();
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Ayşe");
		owner1.setLastName("Bacı");
		owner1.setAddress("Necati Bey Cad.");
		owner1.setCity("İstanbul");
		owner1.setTelephone("123456789");
		Pet aysesPet = new Pet();
		aysesPet.setName("Kuçu");
		aysesPet.setPetType(savedDogPetType);
		aysesPet.setOwner(owner1);
		aysesPet.setBirthdate(LocalDate.now());
		owner1.getPets().add(aysesPet);
		ownerService.save(owner1);
		
		Visit aysesPetVisit = new Visit();
		aysesPetVisit.setPet(aysesPet);
		aysesPetVisit.setDate(LocalDate.now());
		aysesPetVisit.setDescription("Sneezy kuchu");
		visitService.save(aysesPetVisit);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fatma");
		owner2.setLastName("Hanım");
		owner2.setAddress("Karamazak Cad.");
		owner2.setCity("Bursa");
		owner2.setTelephone("987654321");
		
		Pet fatmasCat = new Pet();
		fatmasCat.setName("Pisi");
		fatmasCat.setPetType(savedCatPetType);
		fatmasCat.setOwner(owner2);
		fatmasCat.setBirthdate(LocalDate.now());
		owner2.getPets().add(fatmasCat);
		
		ownerService.save(owner2);
		
		System.out.println("Loaded owners!");
		
		Vet vet0 = new Vet();
		vet0.setFirstName("Zara");
		vet0.setLastName("Lara");
		vet0.getSpecialties().add(savedDentistry);
		vetService.save(vet0);
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Hasan");
		vet1.setLastName("Bakan");
		vet1.getSpecialties().add(savedRadiology);
		vet1.getSpecialties().add(savedSurgery);
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Tarkan");
		vet2.setLastName("Yakan");
		vet2.getSpecialties().add(savedSurgery);
		vet2.getSpecialties().add(savedDentistry);
		
		vetService.save(vet2);
		
		
		Vet vet3 = new Vet();
		vet3.setFirstName("Buray");
		vet3.setLastName("Yatay");
		// Test no specialty.
		//vet3.getSpecialties().add(savedSurgery); 
		vetService.save(vet3);
		
		System.out.println("Loaded vets!");

	}

}

