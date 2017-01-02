package fr.pizzeria.admin.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.service.PizzaServiceEJB;
import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;
@Path("/pizzas")
public class PizzaRessources {

	@PersistenceContext private EntityManager em;
	
	@EJB private PizzaServiceEJB ejbPizzaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> list() {
//		TypedQuery<Pizza> rqt = em.createQuery("select p from Pizza p", Pizza.class);
//		List<Pizza> pizzas = rqt.getResultList();
		
		
	return ejbPizzaService.findAll();

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Pizza p){
		//TODO rajouter la fonction save dans EJB
		Logger logger = Logger.getLogger(PizzaRessources.class.getName());
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		logger.log(Level.WARNING, "Ajout de : " + p.getNom() + " " + p.getCode()) ;
		ejbPizzaService.save(p);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Pizza p){
		//TODO rajouter la fonction update dans EJB
		Logger logger = Logger.getLogger(PizzaRessources.class.getName());
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		logger.log(Level.WARNING, "Modification de : "+ p.getNom() + " " + p.getCode()) ;
		ejbPizzaService.updatePizza(p);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(Pizza p){
		//TODO rajouter la fonction delete  dans EJB
		Logger logger = Logger.getLogger(PizzaRessources.class.getName());
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		logger.log(Level.WARNING, "Suppression de : "+ p.getNom() + " " + p.getCode()) ;
		ejbPizzaService.deletePizza(p);
	}
	
}
