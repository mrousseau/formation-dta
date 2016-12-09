package fr.pizzeria.dao.pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoBDD implements PizzaDao {

	ResourceBundle bundle = ResourceBundle.getBundle("application");
	
	private Connection connection; 
	Statement statement;
	
	@Override
	public List<Pizza> findAll() {
 
		List<Pizza> newListPizza = new ArrayList<>(); 
		ResultSet result = readBDD("SELECT * FROM pizza");
		try {
			while(result.next()) {		
				Pizza p = new Pizza(result.getInt("id"), 
									result.getString("code"),
									result.getString("nom"), 
									Double.parseDouble(result.getBigDecimal("prix").toString()),
									CategoriePizza.valueOf(result.getString("categoriePizza")));
				newListPizza.add(p);
				Pizza.setNbPizzas(+1);
				}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return newListPizza;
	}

	@Override
	public void save(Pizza p) {
		writeBDD("INSERT INTO pizza(code,nom,prix,categoriePizza) VALUES ('"  + p.getCode() + "','" + p.getNom() +  "','" + p.getPrix() + "','" + p.getCategoriePizza()+"');"); 
		}

	@Override
	public void updatePizza(int id, Pizza p) {
		writeBDD("UPDATE pizza SET code='"+ p.getCode() +"',nom='"+ p.getNom()+"',prix='"+ p.getPrix()+"',categoriePizza='"+ p.getCategoriePizza()+"' WHERE id="+ id+ ";");
	}

	@Override
	public void deletePizza(int id) {
		writeBDD("DELETE FROM pizza WHERE id="+ id+";");
		
	}
	
	
	private ResultSet readBDD(String action){
		ResultSet resultats = null;
						try {
							connection =  DriverManager.getConnection(bundle.getString("url.impl"),bundle.getString("user.impl"),bundle.getString("pwd.impl"));
							statement = connection.createStatement();
							resultats = statement.executeQuery(action);
						} catch (SQLException e) {
							e.printStackTrace();
						}

		
		return resultats; 
	}
	
	private int writeBDD(String action){
		int status = -1;
		try {
			connection =  DriverManager.getConnection(bundle.getString("url.impl"),bundle.getString("user.impl"),bundle.getString("pwd.impl"));
			statement = connection.createStatement();
			status = statement.executeUpdate(action);
			System.out.println(action);
		} catch (Exception e) {
		}
		System.out.println(status);
		return status;
	}
}
