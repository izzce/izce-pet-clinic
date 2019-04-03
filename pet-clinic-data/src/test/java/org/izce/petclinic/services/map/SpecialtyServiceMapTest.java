package org.izce.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.izce.petclinic.model.Specialty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpecialtyServiceMapTest {
	SpecialtyServiceMap specialtyService;
	final Long specialtyId = 1L;
	
	@BeforeEach
	void setUp() throws Exception {
		specialtyService = new SpecialtyServiceMap();
		
		specialtyService.save(Specialty.builder().id(specialtyId).build());
	}

	@Test
	void testFindAll() {
		Set<Specialty> specialties = specialtyService.findAll();
		
		assertEquals(1,  specialties.size());
	}

	@Test
	void testFindById() {
		Specialty specialty = specialtyService.findById(specialtyId);
		
		assertEquals(specialtyId, specialty.getId());
	}

	@Test
	void testSave() {
		Long id2 = 2L;
		specialtyService.save(Specialty.builder().id(id2).build());
		
		assertEquals(2, specialtyService.findAll().size());
	}

	@Test
	void testDeleteById() {
		specialtyService.deleteById(specialtyId);
		
		assertEquals(0, specialtyService.findAll().size());
	}

	@Test
	void testDelete() {
		specialtyService.delete(specialtyService.findById(specialtyId));
		
		assertEquals(0, specialtyService.findAll().size());
	}

}
