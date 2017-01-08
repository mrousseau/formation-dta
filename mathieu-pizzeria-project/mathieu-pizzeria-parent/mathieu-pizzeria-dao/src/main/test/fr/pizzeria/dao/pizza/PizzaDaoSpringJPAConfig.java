package fr.pizzeria.dao.pizza;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan("fr.pizzeria.dao")
@EnableJpaRepositories("fr.pizzeria")
public class PizzaDaoSpringJPAConfig {

	/*
	 * H2 + JPA
	 * 
	 * @Bean public LocalEntityManagerFactoryBean EntityManager() {
	 * LocalEntityManagerFactoryBean entity = new
	 * LocalEntityManagerFactoryBean();
	 * entity.setPersistenceUnitName("mathieu-h2"); return entity; }
	 * 
	 * @Bean public PlatformTransactionManager TransactionManager() { return new
	 * JpaTransactionManager(); }
	 */

	@Bean 
	public DataSource dataSource(){
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
		.setType(EmbeddedDatabaseType.H2)
		.addScript("pizzeriacodefirst.sql")
		.build();
		return db; 
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("fr.pizzeria");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}
	
	
	
	
	
}
