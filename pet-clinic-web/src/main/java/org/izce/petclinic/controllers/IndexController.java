package org.izce.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({ "", "/", "index", "index.html" })
	public String index() {
		// the name of template file, omitting extension 'html'.
		return "index";
	}
	
	@RequestMapping({"/oups" })
	public String error() {
		return "notimplemented";
	}
}
