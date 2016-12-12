package fr.pizzeria.dao.pizza;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichier implements PizzaDao {
	Path pathRep = FileSystems.getDefault().getPath(
			"C:/Users/ETY8/Documents/workspace/formation-dta/mathieu-pizzeria-project/mathieu-pizzeria-parent/mathieu-pizzeria-model/data");

	
	Logger logger = Logger.getLogger(PizzaDaoFichier.class.getName());
	@Override
	public List<Pizza> findAll() {
		Pizza.setNbPizzas(0);
		List<Pizza> pizzas = new ArrayList<Pizza>();
 		try {
			DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathRep);
			Charset charset = Charset.forName("UTF-8");
			directoryStream.forEach(directory -> {
				try {

					List<String> pizza = Files.readAllLines(directory, charset);
					String str = pizza.get(0);
					String parts[] = str.split(",");
					pizzas.add(new Pizza(parts[0], parts[1], Double.parseDouble(parts[2]),
							CategoriePizza.valueOf(parts[3])));

				} catch (IOException e) {

					logger.log(Level.WARNING, "Erreur : " + e.getMessage(), e) ;
				}
			});
			directoryStream.close();
		} catch (IOException e) {
			logger.log(Level.WARNING, "Erreur : " + e.getMessage(), e) ;
		}
		return pizzas;
	}

	@Override
	public void save(Pizza p) {
		Path pathFichier = FileSystems.getDefault().getPath(pathRep + "/" + p.getCode() + ".txt");
		try {
			Files.createFile(pathFichier);
			Charset charset = Charset.forName("UTF-8");
			List<String> lines = new ArrayList<>();
			lines.add(p.getCode() + "," + p.getNom() + "," + p.getPrix() + "," + p.getCategoriePizza());
			Files.write(pathFichier, lines, charset, StandardOpenOption.APPEND);
		} catch (IOException e) {
			logger.log(Level.WARNING, "Erreur : " + e.getMessage(), e) ;
		}
	}

	@Override
	public void updatePizza(int id, Pizza p) {
		findAll().get(id).getCode();
	}

	@Override
	public void deletePizza(int id) {
		findAll().get(id).getCode();
	}

}
