package fr.pizzeria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaResource {
	
	
	//int id, String code, String nom, double prix, CategoriePizza categoriePizza, String url
	@GetMapping
	public List<Pizza> listPizza(){
		
		List<Pizza> l = new ArrayList<Pizza>(); 
		l.add(new Pizza(1,"PEP", "PEPEPEPEP", 15.50, CategoriePizza.VIANDE, "www.google.com"));
		l.add(new Pizza(1,"PEP", "PEPEPEPEP", 15.50, CategoriePizza.VIANDE, "www.google.com"));
		l.add(new Pizza(1,"PEP", "PEPEPEPEP", 15.50, CategoriePizza.VIANDE, "www.google.com"));
		l.add(new Pizza(1,"PEP", "PEPEPEPEP", 15.50, CategoriePizza.VIANDE, "www.google.com"));
		l.add(new Pizza(1,"PEP", "PEPEPEPEP", 15.50, CategoriePizza.VIANDE, "www.google.com"));
		l.add(new Pizza(1,"PEP", "PEPEPEPEP", 15.50, CategoriePizza.VIANDE, "www.google.com"));
		return l;
	}

}
