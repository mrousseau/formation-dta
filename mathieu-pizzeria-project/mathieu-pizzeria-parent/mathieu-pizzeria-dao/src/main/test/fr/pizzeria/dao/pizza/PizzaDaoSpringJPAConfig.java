package fr.pizzeria.dao.pizza;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan("fr.pizzeria.dao")
@EnableJpaRepositories("fr.pizzeria")
@EnableAspectJAutoProxy
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

//	@Bean 
//	public DataSource dataSource(){
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		EmbeddedDatabase db = builder
//		.setType(EmbeddedDatabaseType.H2)
//		.addScript("pizzeriacodefirst.sql")
//		.build();
//		return db; 
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		JpaTransactionManager txManager = new JpaTransactionManager();
//		txManager.setEntityManagerFactory(entityManagerFactory());
//		return txManager;
//	}
//
//	@Bean public EntityManagerFactory entityManagerFactory() { 
//		return new JpaTransactionManager().getEntityManagerFactory(); 
//		}
	
	@Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor beanPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("mathieu-h2");
        return entityManagerFactoryBean;
    }
	
	
	
}
