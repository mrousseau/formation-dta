package fr.pizzeria.action;

import fr.pizzeria.ihm.IhmUtil;

public class Inscription extends MenuInterface {

	private IhmUtil ihmUtil;

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}


	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}
	
	public Inscription(IhmUtil ihmUtil) {
		super();
		this.setLibelle("S'inscrire");
		this.setIhmUtil(ihmUtil);
	}
	
	
	@Override
	public void executeAction() {
		System.out.println("lancement de la fonction d'inscription...");
		
	}

	@Override
	public void show() {
		System.out.println(this.getLibelle());
	}

}
