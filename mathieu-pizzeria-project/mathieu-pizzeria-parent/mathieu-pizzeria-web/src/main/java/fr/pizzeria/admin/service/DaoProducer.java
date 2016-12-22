package fr.pizzeria.admin.service;

import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;

public class DaoProducer {

	
	@Produces public PizzaDao GetPizzaDao(){
		return new PizzaDaoJPA();
	}
	
}
