package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoDataJpa;

public class PizzaFactoryDataJpa extends PizzaDaoFactory {

	public PizzaFactoryDataJpa() {
		super(new PizzaDaoDataJpa());
	}

}
