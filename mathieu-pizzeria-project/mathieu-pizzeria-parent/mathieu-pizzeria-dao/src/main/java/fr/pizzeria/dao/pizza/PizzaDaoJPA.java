package fr.pizzeria.dao.pizza;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.*;


public class PizzaDaoJPA implements PizzaDao{
	private EntityManagerFactory emf; 
	private EntityManager em;
	
	public PizzaDaoJPA() {
		emf = Persistence.createEntityManagerFactory("manager1");
	}

	
	@Override                                                                            
	public List<Pizza> findAll() {
		init();
		TypedQuery<Pizza> rqt = em.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> l = rqt.getResultList();
		close();
		return l;
	}

	@Override
	public void save(Pizza p) {
		init();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		close();
	}

	@Override
	public void updatePizza(int id, Pizza p) {
		init();
		Pizza piz = em.find(Pizza.class, id);
		em.getTransaction().begin();
		piz.setCode(p.getCode());
		piz.setNom(p.getNom());
		piz.setPrix(p.getPrix());
		piz.setCategoriePizza(p.getCategoriePizza());
		em.getTransaction().commit();
		close();
		 
	}

	@Override
	public void deletePizza(int id) {
		init();
		Pizza piz = em.find(Pizza.class, id);
//		TODO Attendre validation avant suppression
//		em.getTransaction().begin();
//		em.remove(piz);
//		em.getTransaction().commit();
		em.getTransaction().begin();
		piz.setArchive(true);
		em.getTransaction().commit();
		
		close();
	}

	private void init(){
		em = emf.createEntityManager();
	}
	
	private void close(){
		em.close();
	}
}
