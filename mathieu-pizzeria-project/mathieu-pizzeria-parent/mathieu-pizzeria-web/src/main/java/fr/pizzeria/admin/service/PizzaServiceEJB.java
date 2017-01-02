package fr.pizzeria.admin.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Session Bean implementation class PizzaServiceEJB
 */
@Stateless
@LocalBean
public class PizzaServiceEJB {

	@PersistenceContext private EntityManager em;
    /**
     * Default constructor. 
     */
    public PizzaServiceEJB() {
        // TODO Auto-generated constructor stub
    	
    }
    
    public List<Pizza> findAll(){
				TypedQuery<Pizza> rqt = em.createQuery("select p from Pizza p", Pizza.class);
				List<Pizza> l = rqt.getResultList();
    		return l; 
    }
    
    
    public void save(Pizza p ){
    	em.persist(p);
    }
    
    public void updatePizza(Pizza p){
    	Pizza piz = em.find(Pizza.class, p.getId());
    	piz.setCode(p.getCode());
    	piz.setNom(p.getNom());
    	piz.setPrix(p.getPrix());
    	piz.setUrl(p.getUrl());
    	piz.setCategoriePizza(p.getCategoriePizza());
    	piz.setArchive(p.isArchive());
//    	em.getTransaction().commit();
    }
    
    public void deletePizza(Pizza p){
    	Pizza piz = em.find(Pizza.class, p.getId());
    	piz.setArchive(true);
//		em.getTransaction().commit();
    }

}
