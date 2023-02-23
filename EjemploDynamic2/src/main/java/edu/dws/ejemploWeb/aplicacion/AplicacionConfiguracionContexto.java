package edu.dws.ejemploWeb.aplicacion;

import java.util.Properties;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import edu.dws.ejemploWeb.aplicacion.dal.GestionAlumnos;



@PropertySource("classpath:archivo.properties")
@EnableJpaRepositories("edu.dws.ejemploWeb.aplicacion.dal")
@Configuration
@ComponentScan
public class AplicacionConfiguracionContexto {

	@Autowired
	private Environment propiedades;
	
	//Tener un bean que llame a las variables del properties que tiene las constantes del datasource, emf y transacciones
	@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(propiedades.getProperty("spring.dataSource.url"));
	    dataSource.setUrl(propiedades.getProperty("spring.dataSource.database"));
	    dataSource.setUsername(propiedades.getProperty("spring.dataSource.username"));
	    dataSource.setPassword(propiedades.getProperty("spring.dataSource.password" ));
	    return dataSource;
	}

	
	//Crear el entity manager y transaction Manager
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        	em.setDataSource(dataSource());
    	    em.setPackagesToScan(GestionAlumnos.class.getPackage().getName());
    	    
    	    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
      	    jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
    	    jpaVendorAdapter.setDatabasePlatform(propiedades.getProperty("hibernate.dialect"));
    	    jpaVendorAdapter.setGenerateDdl(propiedades.getProperty("hibernate.generateDdl", Boolean.class));
    	    jpaVendorAdapter.setShowSql(propiedades.getProperty("hibernate.show_sql",Boolean.class));
    	    em.setJpaVendorAdapter(jpaVendorAdapter);
    	    
    	    Properties jpaProperties = new Properties();
    	    jpaProperties.put("hibernate.hbm2ddl.auto", propiedades.getProperty("hibernate.hbm2ddl.auto"));
    	    jpaProperties.put("hibernate.show_sql", propiedades.getProperty("hibernate.show_sql"));
    	    jpaProperties.put("hibernate.format_sql", propiedades.getProperty("hibernate.format_sql"));
    	    em.setJpaProperties(jpaProperties);
    	    
		return em;
	}
        
        @Bean
        public PlatformTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
            return transactionManager;
        }
}
