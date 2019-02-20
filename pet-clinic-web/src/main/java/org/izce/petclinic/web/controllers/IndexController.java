package org.izce.petclinic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({ "", "/", "index", "index.htm", "index.html" })
	public String index() {
		// the name of template file, omitting extension 'html'.
		return "index";
	}
}
