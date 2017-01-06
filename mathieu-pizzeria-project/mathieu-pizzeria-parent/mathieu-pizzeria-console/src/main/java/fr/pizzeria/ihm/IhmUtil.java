package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoSpringJPA;
import fr.pizzeria.dao.service.PizzaDaoFactory;

@Component
public class IhmUtil {
	
	@Autowired
	private Scanner scanner;
	@Autowired
 	private @Qualifier("pizzaDaoSpringJPA") PizzaDao pizzaDao;

	public Scanner getScanner() {
		return this.scanner;
	}

	public PizzaDao getPizzaDao() {
		return this.pizzaDao;
	}

}