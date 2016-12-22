package fr.pizzeria.admin.service;

import java.util.List;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.model.Pizza;

import javax.ejb.EJB;
import javax.inject.Inject;

public class PizzaService {

//	@Inject private PizzaDao pizzaDaoJPA;
	@EJB private PizzaServiceEJB pizzaDaoJPA;
	public List<Pizza> findAll() {
//		PizzaDao pizzaDao = new PizzaDaoJPA();
//		return pizzaDao.findAll();
		return pizzaDaoJPA.findAll();
	}

}
