package fr.pizzeria.dao.pizza;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoBDD implements PizzaDao {

	private String url = "jdbc:mysql://localhost:3306/pizzadb?useSSL=false";
	private String user = "root";
	private String password = "";
	private Connection connection; 
	Statement statement;
	
	@Override
	public List<Pizza> findAll() {
 
		List<Pizza> newListPizza = new ArrayList<>(); 
		ResultSet result = readBDD("SELECT * FROM pizza");
		try {
			while(result.next()) {		
				Pizza p = new Pizza(result.getInt("id"), 
									result.getString("codePizza"),
									result.getString("nom"), 
									Double.parseDouble(result.getBigDecimal("prix").toString()),
									CategoriePizza.valueOf(result.getString("categorie")));
				newListPizza.add(p);
				Pizza.setNbPizzas(+1);
				}	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return newListPizza;
	}

	@Override
	public void save(Pizza p) {
		writeBDD("INSERT INTO pizza(codepizza,nom,prix,categorie) VALUES ('"  + p.getCode() + "','" + p.getNom() +  "','" + p.getPrix() + "','" + p.getCategoriePizza()+"');"); 
		}

	@Override
	public void updatePizza(int id, Pizza p) {
		writeBDD("UPDATE pizza SET codepizza='"+ p.getCode() +"',nom='"+ p.getNom()+"',prix='"+ p.getPrix()+"',categorie='"+ p.getCategoriePizza()+"' WHERE id="+ id+ ";");
	}

	@Override
	public void deletePizza(int id) {
		writeBDD("DELETE FROM pizza WHERE id="+ id+";");
		
	}
	
	
	private ResultSet readBDD(String action){
		ResultSet resultats = null;
						try {
							connection =  DriverManager.getConnection(url,user,password);
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
			connection =  DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();
			System.out.println(action);
			status = statement.executeUpdate(action);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(status);
		return status;
	}
}
