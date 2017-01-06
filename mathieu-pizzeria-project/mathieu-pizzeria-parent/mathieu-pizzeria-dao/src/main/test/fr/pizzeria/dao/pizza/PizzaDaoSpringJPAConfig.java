package fr.pizzeria.dao.pizza;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("fr.pizzeria.dao")
@EnableTransactionManagement
public class PizzaDaoSpringJPAConfig {

	
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
