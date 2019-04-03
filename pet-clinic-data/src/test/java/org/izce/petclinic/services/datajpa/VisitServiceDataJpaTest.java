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

import org.izce.petclinic.model.Visit;
import org.izce.petclinic.repositories.VisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VisitServiceDataJpaTest {

	@Mock
	VisitRepository visitRepository;

	@InjectMocks
	VisitServiceDataJpa visitService;

	final Long id1 = 1L;
	final Long id2 = 2L;

	Visit visit;

	@BeforeEach
	void setUp() throws Exception {
		visit = Visit.builder().id(id1).build();
	}

	@Test
	void testSave() {
		when(visitRepository.save(any())).thenReturn(visit);

		Visit savedVisit = visitService.save(visit);
		assertNotNull(savedVisit);
		assertEquals(id1, savedVisit.getId());
		verify(visitRepository).save(any());
	}

	@Test
	void testFindAll() {
		Set<Visit> visits = new HashSet<Visit>();
		visits.add(visit);
		visits.add(Visit.builder().id(id2).build());

		when(visitRepository.findAll()).thenReturn(visits);

		Set<Visit> returnedVisits = visitService.findAll();
		assertNotNull(returnedVisits);
		assertEquals(2, returnedVisits.size());
		verify(visitRepository).findAll();
	}

	@Test
	void testFindById() {
		when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));

		Visit returnedVisit = visitService.findById(id1);
		assertNotNull(returnedVisit);
		assertEquals(id1, returnedVisit.getId());
		verify(visitRepository).findById(anyLong());
	}

	@Test
	void testDelete() {
		visitService.delete(visitService.findById(id1));

		verify(visitRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		visitService.deleteById(id1);

		verify(visitRepository).deleteById(anyLong());
	}

}
