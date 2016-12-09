package fr.pizzeria.action;

import fr.pizzeria.ihm.IhmUtil;

public class Delete extends MenuInterface {

	private IhmUtil ihmUtil;

	public Delete(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("Supprimer une pizza");
	}

	@Override
	public void executeAction() {

		this.ihmUtil.getPizzaDao().findAll().forEach(p -> System.out.println( "[" + p.getId() + "] -- "+ p.getCode() + " --> " + p.getNom() + " (" + p.getPrix() + "€)" ));

		System.out.println("Veuillez choisir la pizza Ã  supprimer\n");
		int choix;
		choix = this.ihmUtil.getScanner().nextInt();
		this.ihmUtil.getPizzaDao().deletePizza(choix);
//				
	}

	@Override
	public void show() {
		System.out.println(this.getLibelle());
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}
}
