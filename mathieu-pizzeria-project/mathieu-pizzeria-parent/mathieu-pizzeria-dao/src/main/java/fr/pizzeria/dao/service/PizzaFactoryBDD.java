package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDaoBDD;
import fr.pizzeria.dao.pizza.PizzaDaoFichier;

public class PizzaFactoryBDD extends PizzaDaoFactory {
	public PizzaFactoryBDD() {
		super(new PizzaDaoBDD());
	}

}
