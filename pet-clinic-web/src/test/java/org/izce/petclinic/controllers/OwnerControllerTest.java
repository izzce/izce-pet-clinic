package org.izce.petclinic.controllers;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matchers;
import org.izce.petclinic.model.Owner;
import org.izce.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	OwnerService ownerService;
	@InjectMocks
	OwnerController controller;
	Set<Owner> owners;
	MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
		owners = new HashSet<Owner>();
		owners.add(Owner.builder().id(1L).build());
		owners.add(Owner.builder().id(2L).build());
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void testListOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		
		mockMvc.perform(get("/owners"))
		.andExpect(status().isOk())
		.andExpect(view().name("owners/index"))
		.andExpect(model().attribute("owners", Matchers.hasSize(2)));
	}
	
	@Test
	void testListOwnersByIndex() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		
		mockMvc.perform(get("/owners/index"))
		.andExpect(status().isOk())
		.andExpect(view().name("owners/index"))
		.andExpect(model().attribute("owners", Matchers.hasSize(2)));
	}

	@Test
	void testFindOwners() throws Exception {
		mockMvc.perform(get("/owners/find"))
		.andExpect(status().isOk())
		.andExpect(view().name("notimplemented"));
		
		verifyZeroInteractions(ownerService);	
	}

}
