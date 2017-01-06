package fr.pizzeria.dao.pizza;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

//@Configuration
//@ComponentScan("fr.pizzeria.dao")
public class PizzaDaoSrpingConfig {
	
	
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


}
