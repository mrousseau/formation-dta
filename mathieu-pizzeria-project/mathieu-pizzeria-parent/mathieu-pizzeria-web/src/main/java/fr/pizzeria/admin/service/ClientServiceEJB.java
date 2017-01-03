package fr.pizzeria.admin.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

@Stateless
@LocalBean
public class ClientServiceEJB {

	@PersistenceContext private EntityManager em;
	
	/*
	 * Constructor default 
	 * */
	
	public ClientServiceEJB(){
	}
	
	
	public List<Client> findAll(){
		TypedQuery<Client> rqt = em.createQuery("SELECT c FROM Client c", Client.class);
		List<Client> l = rqt.getResultList();
		return l;
	}
	
	public void save(Client c) {
		em.persist(c);
	}
	
	public void update(Client c){
		Client client = em.find(Client.class, c.getID());
		client.setAdresse(c.getNom());
		client.setDateNaissance(c.getDateNaissance());
		client.setNom(c.getNom());
		client.setPrenom(c.getPrenom());
		client.setTelephone(c.getTelephone());
	}
	
	
}
