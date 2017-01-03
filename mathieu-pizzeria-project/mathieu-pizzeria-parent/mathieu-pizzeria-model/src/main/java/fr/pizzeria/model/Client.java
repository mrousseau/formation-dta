package fr.pizzeria.model;

import java.util.Date;

import javax.persistence.Entity;

import fr.pizzeria.model.Abstract.PersonneAbstract;

@Entity
public class Client extends PersonneAbstract {

	private String adresse; 
	private String Telephone;
	private Date dateNaissance;
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
}
