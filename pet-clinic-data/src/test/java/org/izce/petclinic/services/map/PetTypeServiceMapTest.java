package org.izce.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.izce.petclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PetTypeServiceMapTest {
	PetTypeServiceMap petTypeService;
	final Long petTypeId = 1L;
	
	@BeforeEach
	void setUp() throws Exception {
		petTypeService = new PetTypeServiceMap();
		
		petTypeService.save(PetType.builder().id(petTypeId).build());
	}

	@Test
	void testFindAll() {
		Set<PetType> petTypes = petTypeService.findAll();
		
		assertEquals(1, petTypes.size());
	}

	@Test
	void testFindById() {
		PetType petType = petTypeService.findById(petTypeId);
		
		assertEquals(petTypeId, petType.getId());
	}

	@Test
	void testSave() {
		Long id = 2L;
		PetType petType2 = PetType.builder().id(id).build();
		PetType savedPetType = petTypeService.save(petType2);
		
		assertEquals(id, savedPetType.getId());
	}

	@Test
	void testDeleteById() {
		petTypeService.deleteById(petTypeId);
		
		assertEquals(0, petTypeService.findAll().size());
	}

	@Test
	void testDelete() {
		petTypeService.delete(petTypeService.findById(petTypeId));
		
		assertEquals(0, petTypeService.findAll().size());
	}

}
