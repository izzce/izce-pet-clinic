package org.izce.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.izce.petclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PetServiceMapTest {
	PetServiceMap petService;
	final Long petId = 1L;
	
	@BeforeEach
	void setUp() throws Exception {
		petService = new PetServiceMap();
		
		petService.save(Pet.builder().id(petId).build());
	}

	@Test
	void testFindAll() {
		Set<Pet> pets = petService.findAll();
		
		assertEquals(1, pets.size());
	}

	@Test
	void testFindById() {
		Pet pet = petService.findById(petId);
		
		assertEquals(petId, pet.getId());
	}

	@Test
	void testSave() {
		Long secondId = 2L;
		Pet savedPet = petService.save(Pet.builder().id(secondId).build());
		
		assertEquals(secondId, savedPet.getId());
	}

	@Test
	void testDeleteById() {
		petService.deleteById(petId);
		
		assertEquals(0,  petService.findAll().size());
	}

	@Test
	void testDelete() {
		petService.delete(petService.findById(petId));
		
		assertEquals(0,  petService.findAll().size());
	}

}
