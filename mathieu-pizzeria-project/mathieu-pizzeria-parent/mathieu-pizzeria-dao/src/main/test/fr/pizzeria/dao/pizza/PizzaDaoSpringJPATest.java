package fr.pizzeria.dao.pizza;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoSpringJPAConfig.class)
public class PizzaDaoSpringJPATest {

	
	@Autowired @Qualifier("PizzaDaoDataJpa") PizzaDao pizzaDaoDataJpa;
	static
	{
	    Logger rootLogger = Logger.getRootLogger();
	    rootLogger.setLevel(Level.WARN);
	    rootLogger.addAppender(new ConsoleAppender(
	               new PatternLayout("%-6r [%p] %c - %m%n")));
	}
//	@BeforeClass
//	public static void injectionPizza(){
//		List<Pizza> l = new ArrayList<Pizza>();
//		l.add(new Pizza("PEP", "Peperoni", 15.54, CategoriePizza.VIANDE, "www.google.fr"));
//		l.add(new Pizza("ORI", "Oriental", 25.54, CategoriePizza.VIANDE, "www.toto.fr"));	
//		for(Pizza item : l){
//			pizzaDaoSpring.save(item);	
//		}
//		
//	}
	
	@Test
	public void testList() {
		assertEquals(true, pizzaDaoDataJpa.findAll().size()!=0);
	}
	
	@Test
	public void testSave() { 
		Pizza pi = new Pizza("TOT", "TOTOTOTO", 15.50 , CategoriePizza.VIANDE);
		System.out.println(pi);
		pizzaDaoDataJpa.save(pi);
		System.out.println("Liste des Pizzas -> nb : " + pizzaDaoDataJpa.findAll().size() );
		pizzaDaoDataJpa.findAll().forEach(System.out::println);
		assertEquals(true, pizzaDaoDataJpa.findAll().stream().filter(p -> p.getCode().equals("TOT")).findFirst().get().getCode().equals("TOT"));
	}
	
	@Test
	public void testDelete() { 
		Pizza pi = pizzaDaoDataJpa.findAll().stream().filter(p -> p.getCode().equals("TOT")).findFirst().get();
		System.out.println(pi);
		pizzaDaoDataJpa.deletePizza(pi.getId());
		System.out.println("Liste des Pizzas -> nb : " + pizzaDaoDataJpa.findAll().size() );
		pizzaDaoDataJpa.findAll().forEach(System.out::println);
		assertEquals(true, pizzaDaoDataJpa.findAll().stream().filter(p -> p.getCode().equals("TOT")).findFirst().get().isArchive());
	}

}
