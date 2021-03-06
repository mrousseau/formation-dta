package fr.pizzeria.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

@Controller
public class List extends MenuInterface {

	@Autowired
	private IhmUtil ihmUtil;

	public List(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("Lister les pizzas");
	}

	@Override
	public void executeAction() {
		this.ihmUtil.getPizzaDao().findAll().forEach(p -> System.out.println( p.getCode() + " --> " + p.getNom() + " (" + p.getPrix() + "�)" ));
		System.out.println("------------------ " + Pizza.getNbPizzas() + " nombre de pizza contenu dans le catalogue.");
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
