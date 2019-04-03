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

import org.izce.petclinic.model.Vet;
import org.izce.petclinic.repositories.VetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VetServiceDataJpaTest {

	@Mock
	VetRepository vetRepository;

	@InjectMocks
	VetServiceDataJpa vetService;

	final Long id1 = 1L;
	final Long id2 = 2L;
	final String lastName = "Vettio";

	Vet vet;

	@BeforeEach
	void setUp() throws Exception {
		vet = Vet.builder().id(id1).lastName(lastName).build();
	}

	@Test
	void testSave() {
		when(vetRepository.save(any())).thenReturn(vet);
		Vet savedVet = vetService.save(vet);
		assertNotNull(savedVet);
		verify(vetRepository).save(any());
	}

	@Test
	void testFindAll() {
		Set<Vet> vets = new HashSet<>();
		vets.add(vet);
		vets.add(Vet.builder().id(id2).build());

		when(vetRepository.findAll()).thenReturn(vets);
		Set<Vet> returnedVets = vetService.findAll();
		assertNotNull(returnedVets);
		assertEquals(2, returnedVets.size());
	}

	@Test
	void testFindById() {
		when(vetRepository.findById(anyLong())).thenReturn(Optional.of(vet));

		Vet returnedVet = vetService.findById(id1);

		assertNotNull(returnedVet);
		assertEquals(id1, returnedVet.getId());
	}

	@Test
	void testDelete() {
		vetService.delete(vetService.findById(id1));

		verify(vetRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		vetService.deleteById(id1);

		verify(vetRepository).deleteById(anyLong());
	}

}
