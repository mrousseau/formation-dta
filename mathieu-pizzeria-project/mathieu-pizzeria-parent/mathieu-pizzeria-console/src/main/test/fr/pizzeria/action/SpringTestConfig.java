package fr.pizzeria.action;

import java.util.ResourceBundle;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.service.PizzaDaoFactory;

@Configuration
@ComponentScan("fr.pizzeria")
public class SpringTestConfig {


	@Bean
	@Value("${dao.impl}")
	public PizzaDao pizzaDao(String impl) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		PizzaDaoFactory service = (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
	return service.getPizzaDaoFactory();
	}

	
	@Bean 
	public Scanner sc() {
		Scanner sc = new Scanner(System.in); 
		return sc; 
	}
	
	
}
