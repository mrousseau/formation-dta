package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDaoJPA;

public class PizzaFactoryJPA extends PizzaDaoFactory{

	public PizzaFactoryJPA() {
		super(new PizzaDaoJPA());
	}

}
