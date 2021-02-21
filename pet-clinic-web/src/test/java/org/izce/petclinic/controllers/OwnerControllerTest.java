package org.izce.petclinic.controllers;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;
import java.util.Set;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
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
	MockMvc mockMvc;
	Set<Owner> owners;
	List<Owner> ownerList;
	
	@BeforeEach
	void setUp() throws Exception {
		ownerList = Lists.list(Owner.builder().id(1L).build(), Owner.builder().id(2L).build());
		owners = Sets.newHashSet(ownerList);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	void testListOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		
		mockMvc.perform(get("/owners/index"))
		.andExpect(status().isOk())
		.andExpect(view().name("owners/index"))
		.andExpect(model().attribute("owners", hasSize(2)));
	}
	
	@Test
	void testListOwnersByIndex() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		
		mockMvc.perform(get("/owners/index"))
		.andExpect(status().isOk())
		.andExpect(view().name("owners/index"))
		.andExpect(model().attribute("owners", hasSize(2)));
	}

	@Test
	void testFindOwners() throws Exception {
		mockMvc.perform(get("/owners/find"))
		.andExpect(status().isOk())
		.andExpect(view().name("owners/findOwners"))
		.andExpect(model().attributeExists("owner"));
		
		verifyZeroInteractions(ownerService);	
	}
	
	@Test
	void testProcessFindFormReturnMany() throws Exception {
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(ownerList);
		
		mockMvc.perform(get("/owners"))
		.andExpect(status().isOk())
		.andExpect(view().name("owners/ownersList"))
		.andExpect(model().attribute("selections", hasSize(2)));
	}
	
	@Test
	void testProcessFindFormReturnOne() throws Exception {
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Lists.list(ownerList.get(0)));
		
		mockMvc.perform(get("/owners"))
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name("redirect:/owners/1"));
	}
	
	@Test
	void displayOwner() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(ownerList.get(0));
		
		mockMvc.perform(get("/owners/1"))
		.andExpect(status().isOk())
		.andExpect(view().name("owners/ownerDetails"))
		.andExpect(model().attribute("owner", hasProperty("id", is(1L))));
	}

}
