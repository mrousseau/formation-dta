package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDaoBDD;

public class PizzaFactoryBDD extends PizzaDaoFactory {
	public PizzaFactoryBDD() {
		super(new PizzaDaoBDD());
	}

}
