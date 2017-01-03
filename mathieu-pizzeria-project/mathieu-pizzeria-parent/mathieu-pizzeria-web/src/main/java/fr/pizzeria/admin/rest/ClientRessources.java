package fr.pizzeria.admin.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.service.ClientServiceEJB;
import fr.pizzeria.model.Client;

@Path("/clients")
public class ClientRessources {
@PersistenceContext private EntityManager em;
	
	@EJB private ClientServiceEJB ejbPizzaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> list() {
		return ejbPizzaService.findAll(); 
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Client c){
		ejbPizzaService.save(c);
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Client c){
		//TODO updateCLient
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(Client c){
		//TODO delete client
	}
	
}
