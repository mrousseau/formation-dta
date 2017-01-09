package fr.pizzeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ingredientController {

	@RequestMapping(value = "/ingr", method = RequestMethod.GET)
	@ResponseBody    
	public String bonjour() {        
		return "vuebonjour";    
	}
	
	
}
