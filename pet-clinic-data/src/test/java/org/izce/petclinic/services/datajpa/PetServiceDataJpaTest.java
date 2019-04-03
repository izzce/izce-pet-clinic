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

import org.izce.petclinic.model.Pet;
import org.izce.petclinic.repositories.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetServiceDataJpaTest {
	@Mock
	PetRepository petRepository;

	@InjectMocks
	PetServiceDataJpa petService;

	final String name = "pettish";
	final Long id1 = 1L;
	final Long id2 = 2L;

	Pet pet;

	@BeforeEach
	void setUp() throws Exception {
		pet = Pet.builder().id(id1).name(name).build();
	}

	@Test
	void testSave() {
		when(petRepository.save(any())).thenReturn(pet);

		Pet savedPet = petService.save(pet);

		assertNotNull(savedPet);
		verify(petRepository).save(any());
	}

	@Test
	void testFindAll() {
		Set<Pet> pets = new HashSet<Pet>();
		pets.add(pet);
		pets.add(Pet.builder().id(id2).build());

		when(petRepository.findAll()).thenReturn(pets);

		Set<Pet> returnedPets = petService.findAll();

		assertNotNull(returnedPets);
		assertEquals(2, returnedPets.size());
	}

	@Test
	void testFindById() {
		when(petRepository.findById(anyLong())).thenReturn(Optional.of(pet));

		Pet returnedPet = petService.findById(id1);
		assertNotNull(returnedPet);
		assertEquals(id1, returnedPet.getId());
	}

	@Test
	void testFindByIdNotFound() {
		when(petRepository.findById(anyLong())).thenReturn(Optional.empty());

		Pet returnedPet = petService.findById(id1);
		assertNull(returnedPet);
	}

	@Test
	void testDelete() {
		petService.delete(petService.findById(id1));

		verify(petRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		petService.deleteById(id1);

		verify(petRepository).deleteById(anyLong());
	}

}
