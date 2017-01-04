package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.service.PizzaFactoryJPA;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfig {

	@Bean
	public PizzaDao pizzaDao() {
		PizzaFactoryJPA service = new PizzaFactoryJPA();
	return service.getPizzaDaoFactory();
	}

	
	@Bean 
	public Scanner sc() {
		Scanner sc = new Scanner(System.in); 
		return sc; 
	}
	

	
	
}
