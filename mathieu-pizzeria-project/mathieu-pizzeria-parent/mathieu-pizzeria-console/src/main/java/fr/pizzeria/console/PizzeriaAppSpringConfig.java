package fr.pizzeria.console;

import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/*
 * Produit un bean de configuration
 * puis definit le répertoire qu'il doit scanner 
 * */
@Configuration
@ComponentScan("fr.pizzeria")
public class PizzeriaAppSpringConfig {
	
	
	/*@Bean
	public PizzaDao pizzaDao() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		System.out.println(daoImpl);
		PizzaDaoFactory pizzaDao = (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
		return pizzaDao.getPizzaDaoFactory();
	}*/

//	@Bean
//	public DataSource getDataSrouce(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeriacodefirst?useSSL=false");
//		dataSource.setUsername("root");
//		dataSource.setPassword("");
//		return dataSource; 
//	}
//	
	
	@Bean 
	public DataSource getDataSource(){
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
		.setType(EmbeddedDatabaseType.H2)
		.addScript("pizzeriacodefirst.sql")
		.build();
		return db; 
	}
		
	@Bean 
	public Scanner sc() {
		Scanner sc = new Scanner(System.in); 
		return sc; 
	}
		
}
