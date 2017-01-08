package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.Pizza;
@Repository
@Qualifier("enabled")
public class PizzaDaoDataJpa implements PizzaDao {

	@Autowired
	IPizzaRepository iPizzaRepos;
	
	@Autowired
	private DataSource dataSource;

	@Override
	public List<Pizza> findAll() {
		
		return iPizzaRepos.findAll();
	}

	@Override
	public void save(Pizza p) {
		iPizzaRepos.save(p);
		
	}

	@Override
	public void updatePizza(int id, Pizza p) {
		Pizza piz = iPizzaRepos.findAll().stream().filter(pizza -> pizza.getId()==id).findFirst().get();
		iPizzaRepos.delete(piz);
		iPizzaRepos.save(p);
	}

	@Override
	public void deletePizza(int id) {
		Pizza piz = iPizzaRepos.findAll().stream().filter(pizza -> pizza.getId()==id).findFirst().get();
		iPizzaRepos.delete(piz);
		
	}



}
