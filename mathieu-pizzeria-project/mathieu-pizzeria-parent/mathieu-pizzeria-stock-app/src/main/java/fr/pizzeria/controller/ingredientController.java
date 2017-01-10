package fr.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pizzeria.dao.pizza.PizzaDao;

@Controller
public class ingredientController {
	
	
	@Autowired
	private PizzaDao pizzaDAo; 

	@RequestMapping(value = "/ingr", method = RequestMethod.GET)
	@ResponseBody    
	public String bonjour() {        
		String str; 
		
		if(pizzaDAo.findAll().stream().findFirst().get().getNom().equals("")){
			str = "HelloWorld";
		} else {
			str = pizzaDAo.findAll().stream().findFirst().get().getNom();
		}
		
		return str;    
		
	}
	
	
}
