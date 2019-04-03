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

import org.izce.petclinic.model.Specialty;
import org.izce.petclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SpecialtyServiceDataJpaTest {
	@Mock
	SpecialtyRepository specialtyRepository;
	@InjectMocks
	SpecialtyServiceDataJpa specialtyService;

	final Long id1 = 1L;
	final Long id2 = 2L;
	final String desc = "Cat-oloji";

	Specialty specialty;

	@BeforeEach
	void setUp() throws Exception {
		specialty = Specialty.builder().id(id1).description(desc).build();
	}

	@Test
	void testSave() {
		when(specialtyRepository.save(any())).thenReturn(specialty);

		Specialty savedSpecialty = specialtyService.save(specialty);
		assertNotNull(savedSpecialty);
		verify(specialtyRepository).save(any());
	}

	@Test
	void testFindAll() {
		Set<Specialty> specialties = new HashSet<>();
		specialties.add(specialty);
		specialties.add(Specialty.builder().id(id2).build());
		when(specialtyRepository.findAll()).thenReturn(specialties);

		Set<Specialty> returnedSpecialties = specialtyService.findAll();
		
		assertNotNull(returnedSpecialties);
		assertEquals(2, returnedSpecialties.size());
	}

	@Test
	void testFindById() {
		when(specialtyRepository.findById(anyLong())).thenReturn(Optional.of(specialty));
		
		Specialty returnedSpecialty = specialtyService.findById(id1);
		assertNotNull(returnedSpecialty);
		assertEquals(id1, returnedSpecialty.getId());
	}

	@Test
	void testDelete() {
		specialtyService.delete(specialtyService.findById(id1));
		
		verify(specialtyRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		specialtyService.deleteById(id1);
		
		verify(specialtyRepository).deleteById(anyLong());
	}

}
