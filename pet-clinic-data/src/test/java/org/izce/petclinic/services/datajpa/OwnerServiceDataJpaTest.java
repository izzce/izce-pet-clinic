package org.izce.petclinic.services.datajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.izce.petclinic.model.Owner;
import org.izce.petclinic.repositories.OwnerRepository;
import org.izce.petclinic.repositories.PetRepository;
import org.izce.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerServiceDataJpaTest {

	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	@Mock
	PetRepository petRepository;

	@InjectMocks
	OwnerServiceDataJpa ownerService;

	private final String lastName = "Bacı";
	private final Long ownerId1 = 1L;
	private final Long ownerId2 = 2L;

	Owner owner;
	
	@BeforeEach
	void setUp() throws Exception {
		owner = Owner.builder().id(ownerId1).lastName(lastName).build();		
	}

	@Test
	void testFindByLastName() {
		when(ownerRepository.findByLastName(any())).thenReturn(owner);
		
		Owner ownerReturned = ownerService.findByLastName(lastName);
		
		assertNotNull(ownerReturned);
		assertEquals(lastName, ownerReturned.getLastName());
		
		verify(ownerRepository).findByLastName(any());
	}

	@Test
	void testFindByLastNameNotFound() {
		Owner owner = ownerService.findByLastName("Hahiho");

		assertNull(owner);
	}

	@Test
	void testSave() {
		when(ownerRepository.save(any())).thenReturn(owner);

		Owner savedOwner = ownerService.save(owner);
		assertNotNull(savedOwner);
		
		verify(ownerRepository).save(any());
	}

	@Test
	void testFindAll() {
		Set<Owner> owners = new HashSet<Owner>();
		owners.add(owner);
		owners.add(Owner.builder().id(2L).build());
		
		when(ownerRepository.findAll()).thenReturn(owners);
		
		Set<Owner> returnedOwners = ownerService.findAll();

		assertNotNull(returnedOwners);
		assertEquals(2, returnedOwners.size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
		
		Owner owner = ownerService.findById(ownerId1);

		assertNotNull(owner);
		assertEquals(ownerId1, owner.getId());
	}
	
	@Test
	void testFindByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		
		Owner owner = ownerService.findById(ownerId1);

		assertNull(owner);
	}

	@Test
	void testDelete() {
		ownerService.delete(ownerService.findById(ownerId2));
		
		verify(ownerRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		ownerService.deleteById(ownerId2);

		verify(ownerRepository).deleteById(anyLong());
	}

}
