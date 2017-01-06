package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDaoSpringJPA;

public class PizzaFactoryJPA extends PizzaDaoFactory{

	public PizzaFactoryJPA() {
//		super(new PizzaDaoJPA());
		super(new PizzaDaoSpringJPA());
	}

}
