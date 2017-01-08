package fr.pizzeria.dao.pizza;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
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

	
	@Autowired @Qualifier("pizzaDaoSpringJPA") PizzaDao pizzaDaoSpring;
	
	
	
//	@BeforeClass
//	public static void injectionPizza(){
//		List<Pizza> l = new ArrayList<Pizza>();
//		l.add(new Pizza("PEP", "Peperoni", 15.54, CategoriePizza.VIANDE, "www.google.fr"));
//		l.add(new Pizza("ORI", "Oriental", 25.54, CategoriePizza.VIANDE, "www.j&m.fr"));	
//		for(Pizza item : l){
//			pizzaDaoSpring.save(item);	
//		}
//		
//	}
	
	@Test
	public void testList() {
		assertEquals(true, pizzaDaoSpring.findAll().size()!=0);
	}
	
	@Test
	public void testSave() { 
		Pizza pi = new Pizza("TOT", "TOTOTOTO", 15.50 , CategoriePizza.VIANDE);
		System.out.println(pi);
		pizzaDaoSpring.save(pi);
		System.out.println("Liste des Pizzas -> nb : " + pizzaDaoSpring.findAll().size() );
		pizzaDaoSpring.findAll().forEach(System.out::println);
		assertEquals(true, pizzaDaoSpring.findAll().stream().filter(p -> p.getCode().equals("TOT")).findFirst().get().getCode().equals("TOT"));
	}
	
	@Test
	public void testDelete() { 
		Pizza pi = pizzaDaoSpring.findAll().stream().filter(p -> p.getCode().equals("TOT")).findFirst().get();
		System.out.println(pi);
		pizzaDaoSpring.deletePizza(pi.getId());
		System.out.println("Liste des Pizzas -> nb : " + pizzaDaoSpring.findAll().size() );
		pizzaDaoSpring.findAll().forEach(System.out::println);
		assertEquals(true, pizzaDaoSpring.findAll().stream().filter(p -> p.getCode().equals("TOT")).findFirst().get().isArchive());
	}

}
