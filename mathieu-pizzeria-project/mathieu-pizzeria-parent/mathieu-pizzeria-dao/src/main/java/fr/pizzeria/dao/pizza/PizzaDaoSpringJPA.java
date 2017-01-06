package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoSpringJPA implements PizzaDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override                                                                            
	public List<Pizza> findAll() {
		TypedQuery<Pizza> rqt = em.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> l = rqt.getResultList();
		return l;
	}

	@Override
	@Transactional
	public void save(Pizza p) {
		em.persist(p);
	}

	@Transactional
	@Override
	public void updatePizza(int id, Pizza p) {
		Pizza piz = em.find(Pizza.class, id);
		piz.setCode(p.getCode());
		piz.setNom(p.getNom());
		piz.setPrix(p.getPrix());
		piz.setCategoriePizza(p.getCategoriePizza());
		 
	}

	@Transactional
	@Override
	public void deletePizza(int id) {
		Pizza piz = em.find(Pizza.class, id);
		piz.setArchive(true);
	}
}
