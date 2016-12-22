package fr.pizzeria.admin.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.model.Pizza;

/**
 * Session Bean implementation class PizzaServiceEJB
 */
@Stateless
@LocalBean
public class PizzaServiceEJB {

	@PersistenceContext(unitName="pizza-db") private EntityManager em;
    /**
     * Default constructor. 
     */
    public PizzaServiceEJB() {
        // TODO Auto-generated constructor stub
    	
    }
    
    public List<Pizza> findAll(){
				TypedQuery<Pizza> rqt = em.createQuery("select p from Pizza p", Pizza.class);
				List<Pizza> l = rqt.getResultList();
				em.close();
    		return l; 
    }

}
