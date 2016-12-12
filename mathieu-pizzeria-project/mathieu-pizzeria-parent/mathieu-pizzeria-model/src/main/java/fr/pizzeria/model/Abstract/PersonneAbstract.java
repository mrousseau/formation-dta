package fr.pizzeria.model.Abstract;

import javax.persistence.InheritanceType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
/**
 * Classe abstraite pour pouvoir faire un client ou un livreur
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonneAbstract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String nom; 
	private String prenom; 
	
	

}
