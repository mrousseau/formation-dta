package fr.pizzeria.ihm;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.action.Inscription;
import fr.pizzeria.action.MenuInterface;

public class Menu {

	Map<Integer, MenuInterface> listeOutils = new HashMap<Integer, MenuInterface>();

	IhmUtil reader;

	public Menu(IhmUtil ihmUtil) {
		listeOutils.put(0, new Inscription(ihmUtil));

		this.reader = ihmUtil;
	}

	public void start() {
		showMenu();
		executeAction();
	}

	private void showMenu() {
		listeOutils.forEach((k, v) -> {
			System.out.println((k + 1) + ": " + v.getLibelle());
		});
	}

	private void executeAction() {

		System.out.println("Faites un choix  \n");

		String value = reader.getScanner().next();

		if (Integer.parseInt(value) < 7) {
			listeOutils.get(Integer.parseInt(value) - 1).executeAction();
			start();
		} else if (Integer.parseInt(value) == 99) {
			listeOutils.get(listeOutils.size() - 1).executeAction();
		}

	}

}
