package fr.pizzeria.model;

import java.util.Date;

import javax.persistence.Entity;

import fr.pizzeria.model.Abstract.PersonneAbstract;

@Entity
public class Client extends PersonneAbstract {

	private String adresse; 
	private String Telephone;
	private Date dateNaissance;
	
	
}
