package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.service.PizzaDaoFactory;

@Component
public class IhmUtil {
	
	@Autowired
	private Scanner scanner;
	@Autowired
	private PizzaDao pizzaDao;

//	public IhmUtil(Scanner scanner, PizzaDaoFactory pizzaFactory) {
//		super();
//		this.scanner = scanner;
//		this.pizzaDao = pizzaFactory.getPizzaDaoFactory();
//	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public PizzaDao getPizzaDao() {
		return this.pizzaDao;
	}

}