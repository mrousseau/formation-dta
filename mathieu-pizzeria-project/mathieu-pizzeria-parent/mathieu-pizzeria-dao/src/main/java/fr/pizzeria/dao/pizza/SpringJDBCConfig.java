package fr.pizzeria.dao.pizza;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan("fr.pizzeria.dao")
public class SpringJDBCConfig {

	
	@Bean
	public DriverManagerDataSource getDataSrouce(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeriacodefirst?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource; 
	}
	
	
}
