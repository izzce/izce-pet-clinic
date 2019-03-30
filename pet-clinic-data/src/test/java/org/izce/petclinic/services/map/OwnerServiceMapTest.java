package org.izce.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.izce.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OwnerServiceMapTest {
	private OwnerServiceMap ownerService;
	private final Long ownerId = 1L;
	private final String lastName = "LASSSST";

	@BeforeEach
	void setUp() throws Exception {
		ownerService = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

		ownerService.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void testFindByLastName() {
		Owner owner = ownerService.findByLastName(lastName);
		
		assertNotNull(owner);
		assertEquals(lastName, owner.getLastName());
	}
	
	@Test
	void testFindByLastNameNotFound() {
		Owner owner = ownerService.findByLastName("LastName-None");
		
		assertNull(owner);
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = ownerService.findAll();

		assertEquals(1, owners.size());
	}

	@Test
	void testFindById() {
		Owner owner = ownerService.findById(1L);

		assertEquals(ownerId, owner.getId());
	}

	@Test
	void testSaveExistingId() {
		Long id = 2L;
		Owner owner2 = Owner.builder().id(id).build();
		Owner savedOwner = ownerService.save(owner2);

		assertEquals(id, savedOwner.getId());
	}

	@Test
	void testSaveNoId() {
		Owner savedOwner = ownerService.save(Owner.builder().build());

		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void testDeleteById() {
		ownerService.deleteById(ownerId);

		assertEquals(0, ownerService.findAll().size());
	}

	@Test
	void testDelete() {
		ownerService.delete(ownerService.findById(ownerId));

		assertEquals(0, ownerService.findAll().size());
	}

}
