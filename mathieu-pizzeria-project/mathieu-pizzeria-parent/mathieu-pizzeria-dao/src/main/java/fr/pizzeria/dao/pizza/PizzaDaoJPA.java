package fr.pizzeria.dao.pizza;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.mysql.jdbc.Connection;

import fr.pizzeria.model.Pizza;


public class PizzaDaoJPA implements PizzaDao{
	private EntityManagerFactory emf; 
	private EntityManager em;
	
	public PizzaDaoJPA() {
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
		em.getTransaction().commit();
		close();
		
	}

	@Override
	public void deletePizza(int id) {
		init();
		Pizza piz = em.find(Pizza.class, id);
		em.getTransaction().begin();
		em.remove(piz);
		em.getTransaction().commit();
		close();
	}

	private void init(){
		emf = Persistence.createEntityManagerFactory("manager1");
		em = emf.createEntityManager();
	}
	
	private void close(){
		em.close();
		emf.close();
	}
}
