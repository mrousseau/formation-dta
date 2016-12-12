package fr.pizzeria.console.client;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


import fr.pizzeria.dao.service.PizzaDaoFactory;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Pizza;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(App.class.getName());
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		Pizza p1 = new Pizza();
		p1.setCode("MAR");

		Pizza p2 = new Pizza();
		p2.setCode("MAR");

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");

		PizzaDaoFactory daoFactory = null;
		try {
			daoFactory = (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
		} catch (InstantiationException e) {
			logger.log(Level.WARNING, "Erreur : " + e.getMessage(), e);

		} catch (IllegalAccessException e) {
			logger.log(Level.WARNING, "Erreur : " + e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			logger.log(Level.WARNING, "Erreur : " + e.getMessage(), e);
		}

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), daoFactory);
		Menu menu = new Menu(ihmUtil);
		menu.start();
	}
}
