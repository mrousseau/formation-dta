package fr.pizzeria.dao.pizza;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoSrpingConfig.class)
public class PizzaDaoSpringJDBCTest {

	  @Autowired PizzaDaoSpringJDBC pizzaDaoSpringjdbc;
	
	
	@Test
	public void test() {
//		System.out.println(pizzaDaoSpringjdbc.findAll().size());
//		assertEquals(null , pizzaDaoSpringjdbc.findAll().size());
//		assertEquals(4,pizzaDaoSpringjdbc.findAll().size());
		pizzaDaoSpringjdbc.findAll().forEach(p -> System.out.println(p.getCode() + " "+ p.getNom() + " " + p.getPrix()));
	}

}
