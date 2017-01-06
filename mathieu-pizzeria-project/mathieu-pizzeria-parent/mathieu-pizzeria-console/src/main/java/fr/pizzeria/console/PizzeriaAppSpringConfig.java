package fr.pizzeria.console;

import java.util.Scanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 * Produit un bean de configuration
 * puis definit le répertoire qu'il doit scanner 
 * */

@Configuration
@ComponentScan("fr.pizzeria")
@EnableTransactionManagement
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
	
//	@Bean 
//	public DataSource getDataSource(){
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		EmbeddedDatabase db = builder
//		.setType(EmbeddedDatabaseType.H2)
//		.addScript("pizzeriacodefirst.sql")
//		.build();
//		return db; 
//	}
		
	@Bean 
	public Scanner sc() {
		Scanner sc = new Scanner(System.in); 
		return sc; 
	}
	
    @Bean
    public LocalEntityManagerFactoryBean EntityManager() {
        LocalEntityManagerFactoryBean entity = new LocalEntityManagerFactoryBean();
        entity.setPersistenceUnitName("manager1");
        return entity;
    }
    
    @Bean    
    public PlatformTransactionManager TransactionManager() {        
    	return new JpaTransactionManager();    
	}
    
    
		
}
