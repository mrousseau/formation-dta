package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToMany
	@JoinTable(name = "commande_pizza", 
	joinColumns = 
		@JoinColumn(name = "commande_id", referencedColumnName = "ID"), 
		inverseJoinColumns = 
		@JoinColumn(name = "pizza_id", referencedColumnName = "ID"))
	private Set<Pizza> pizza;

	@ManyToOne
	@JoinColumn(name="Client")
	private Client client; 
	
	@ManyToOne
	@JoinColumn(name="Livreur")
	private Livreur livreur; 

}
