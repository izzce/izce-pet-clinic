package org.izce.petclinic.services.datajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.izce.petclinic.model.PetType;
import org.izce.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetTypeServiceDataJpaTest {

	@Mock
	PetTypeRepository petTypeRepository;

	@InjectMocks
	PetTypeServiceDataJpa petTypeService;

	final Long id1 = 1L;
	final Long id2 = 2L;
	final String name = "Kitty";

	PetType petType;

	@BeforeEach
	void setUp() throws Exception {
		petType = PetType.builder().id(id1).name(name).build();
	}

	@Test
	void testSave() {
		when(petTypeRepository.save(any())).thenReturn(petType);

		PetType savedPetType = petTypeService.save(petType);

		assertNotNull(savedPetType);
		verify(petTypeRepository).save(any());
	}

	@Test
	void testFindAll() {
		Set<PetType> petTypes = new HashSet<PetType>();
		petTypes.add(petType);
		petTypes.add(PetType.builder().id(id2).build());

		when(petTypeRepository.findAll()).thenReturn(petTypes);

		Set<PetType> returnedPetTypes = petTypeService.findAll();

		assertNotNull(returnedPetTypes);
		assertEquals(2, returnedPetTypes.size());
	}

	@Test
	void testFindById() {
		when(petTypeRepository.findById(anyLong())).thenReturn(Optional.of(petType));

		PetType returnedPetType = petTypeService.findById(id1);

		assertNotNull(returnedPetType);
		assertEquals(id1, returnedPetType.getId());
	}

	@Test
	void testDelete() {
		petTypeService.delete(petTypeService.findById(id1));

		verify(petTypeRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		petTypeService.deleteById(id1);

		verify(petTypeRepository).deleteById(anyLong());
	}

}
