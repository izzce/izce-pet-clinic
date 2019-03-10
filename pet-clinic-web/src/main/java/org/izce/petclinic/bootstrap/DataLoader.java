package org.izce.petclinic.bootstrap;

import java.time.LocalDate;

import org.izce.petclinic.model.Owner;
import org.izce.petclinic.model.Pet;
import org.izce.petclinic.model.PetType;
import org.izce.petclinic.model.Specialty;
import org.izce.petclinic.model.Vet;
import org.izce.petclinic.services.OwnerService;
import org.izce.petclinic.services.PetTypeService;
import org.izce.petclinic.services.SpecialtyService;
import org.izce.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private boolean loaded = false;
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
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
		Specialty radiology = new Specialty();
		radiology.setDescription("radiology");
		Specialty savedRadiology = specialtyService.save(radiology);
		
		Specialty surgery = new Specialty();
		surgery.setDescription("surgery");
		Specialty savedSurgery = specialtyService.save(surgery);
		
		Specialty dentistry = new Specialty();
		dentistry.setDescription("dentistry");
		Specialty savedDentistry = specialtyService.save(dentistry);
		
		
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
		aysesPet.setBirthday(LocalDate.now());
		owner1.getPets().add(aysesPet);
		
		ownerService.save(owner1);
		
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
		fatmasCat.setBirthday(LocalDate.now());
		owner2.getPets().add(fatmasCat);
		
		ownerService.save(owner2);
		
		System.out.println("Loaded owners!");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Hasan");
		vet1.setLastName("Bakan");
		vet1.getSpecialties().add(savedRadiology);
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Tarkan");
		vet2.setLastName("Yakan");
		vet2.getSpecialties().add(savedSurgery);
		vetService.save(vet2);
		
		System.out.println("Loaded vets!");

	}

}

