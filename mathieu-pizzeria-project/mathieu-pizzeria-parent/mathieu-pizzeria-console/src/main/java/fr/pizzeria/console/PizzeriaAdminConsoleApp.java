package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import org.apache.log4j.Logger;


import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	private PizzeriaAdminConsoleApp() {

	}

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(PizzeriaAdminConsoleApp.class.getName());
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		Pizza p1 = new Pizza();
		p1.setCode("MAR");

		Pizza p2 = new Pizza();
		p2.setCode("MAR");


		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		System.out.println(daoImpl);
//		PizzaDaoFactory daoFactory = null;
//		try {
//			daoFactory = (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
//		} catch (InstantiationException e) {
//			logger.log(Level.WARNING, "Erreur : " + e.getMessage(), e) ;
//		
//		} catch (IllegalAccessException e) {
//			logger.log(Level.WARNING, "Erreur : " + e.getMessage(), e) ;
//		} catch (ClassNotFoundException e) {
//			logger.log(Level.WARNING, "Erreur : " + e.getMessage(), e) ;
//		}
//
//		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), daoFactory);
//		Menu menu = new Menu(ihmUtil);
//		menu.start();
		
//		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(daoImpl, "application-config.xml")) {
//			context.getBean(Menu.class).start();
//			}
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class)) {
//			PizzaFactoryBDD service = context.getBean(PizzaFactoryJPA.class);
			context.getBean(Menu.class).start();
		}
		
	}
}