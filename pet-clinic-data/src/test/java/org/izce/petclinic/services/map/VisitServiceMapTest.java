package org.izce.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.izce.petclinic.model.Owner;
import org.izce.petclinic.model.Pet;
import org.izce.petclinic.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VisitServiceMapTest {
	VisitServiceMap visitService;
	Long id = 1L;
	Pet pet;
	Owner owner;
	
	@BeforeEach
	void setUp() throws Exception {
		visitService = new VisitServiceMap();
		owner = Owner.builder().id(id).lastName("petsOwner").build();
		pet = Pet.builder().id(id).owner(owner).build();
		visitService.save(Visit.builder().id(id).pet(pet).build());
	}

	@Test
	void testSaveVisit() {
		Long id2 = 2L;
		owner = Owner.builder().id(id2).lastName("petsOwner").build();
		pet = Pet.builder().id(id2).owner(owner).build();
		visitService.save(Visit.builder().id(id2).pet(pet).build());
		
		assertEquals(id2, visitService.findById(id2).getId());
	}

	@Test
	void testFindAll() {
		assertEquals(1, visitService.findAll().size());
	}

	@Test
	void testFindById() {
		assertEquals(id, visitService.findById(id).getId());
	}

	@Test
	void testDeleteById() {
		visitService.deleteById(id);
		
		assertEquals(0, visitService.findAll().size());
	}

	@Test
	void testDelete() {
		visitService.delete(visitService.findById(id));
		
		assertEquals(0, visitService.findAll().size());
	}

}
