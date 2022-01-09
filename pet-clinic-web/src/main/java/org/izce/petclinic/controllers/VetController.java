package org.izce.petclinic.controllers;

import java.util.Set;

import org.izce.petclinic.model.Vet;
import org.izce.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VetController {
	private final VetService vetService;

	@Autowired
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}

	@RequestMapping({ "/vets", "/vets.html", "/vets/", "/vets/index", "/vets/index.html" })
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
	
	@RequestMapping({ "/api/vets"})
	public @ResponseBody Set<Vet> getVetsJson() {
		return vetService.findAll();
	}
	
}
