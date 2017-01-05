package fr.pizzeria.action;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringTestConfig.class)
public class ListTest {
  
  @Autowired private List listPizza;

@Test
  public void test() {
      assertEquals("Lister les pizzas",listPizza.getLibelle());
  }

}