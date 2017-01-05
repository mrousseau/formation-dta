package fr.pizzeria.dao.service;

import org.springframework.stereotype.Component;

import fr.pizzeria.dao.pizza.PizzaDaoSpringH2;
//import fr.pizzeria.dao.pizza.PizzaDaoBDD;
//import fr.pizzeria.dao.pizza.PizzaDaoSpringJDBC;
@Component
public class PizzaFactoryBDD extends PizzaDaoFactory {
	public PizzaFactoryBDD() {
//		super(new PizzaDaoSpringJDBC());
		/*new PizzaDaoBDD()*/
		super(new PizzaDaoSpringH2());
		
	}

}
