package org.izce.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Set;

import org.izce.petclinic.model.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VetServiceMapTest {
	VetServiceMap vetService;
	final Long vetId = 1L;
	final String lastName = "VetsLast";
	
	@BeforeEach
	void setUp() throws Exception {
		vetService = new VetServiceMap(new SpecialtyServiceMap());
		
		vetService.save(Vet.builder().id(vetId).lastName(lastName).build());
	}

	@Test
	void testSaveVet() {
		Long id = 2L;
		Vet vet2 = Vet.builder().id(id).build();
		Vet savedVet = vetService.save(vet2);
		
		assertEquals(id, savedVet.getId());
	}
	
	@Test
	void testSaveWithNoId() {
		Vet savedVet = vetService.save(Vet.builder().build());

		assertNotNull(savedVet);
		assertNotNull(savedVet.getId());
	}

	@Test
	void testFindAll() {
		Set<Vet> vets = vetService.findAll();
		
		assertEquals(1, vets.size());
	}

	@Test
	void testFindById() {
		Vet vet = vetService.findById(vetId);
		
		assertEquals(vetId, vet.getId());
	}

	@Test
	void testDeleteById() {
		vetService.deleteById(vetId);
		
		assertEquals(0, vetService.findAll().size());
	}

	@Test
	void testDelete() {
		vetService.delete(vetService.findById(vetId));
		
		assertEquals(0, vetService.findAll().size());
	}

}
