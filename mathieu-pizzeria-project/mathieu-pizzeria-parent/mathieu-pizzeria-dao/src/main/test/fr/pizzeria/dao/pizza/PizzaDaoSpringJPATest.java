package fr.pizzeria.dao.pizza;

import static org.junit.Assert.assertEquals;

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
