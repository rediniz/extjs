package br.com.renato.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

/*
 * ESSA CLASSE É RESPONSÁVEL PELA CONFIGURAÇÃO DO JPA NO SPRING.
 * AS INFORMAÇÕES DE ACESSO AO BANCO FORAM COLOCADAS DIRETAMENTE NO CONTEXT.XML DO TOMCAT, 
 * AQUI ELE SÓ FAZ BUSCAR ESSAS INFORMAÇÕES.
 */
public class SpringPersistenceConfig {
	@Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      // INFORMA O PACOTE ONDE ESTÃO AS CLASSES DE MODELO, PARA SEREM MAPEADAS PARA AS TABELAS DO BANCO
	      em.setPackagesToScan(new String[] { "br.com.renato.model" });
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());
	 
	      return em;
	   }

	   @Bean
	   public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	 
	      return transactionManager;
	   }
	 
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	   Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("hibernate.hbm2ddl.auto", "validate");
	      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
	      return properties;
	   }

	//AQUI SÃO TRAZIDOS OS DADOS DE CONEXÃO AO BANCO DIRETO DO TOMCAT (TECNOLOGIA CHAMADA JNDI), E O SPRING USA ELES AUTOMATICAMENTE

	@Bean
	DataSource dataSource() {
		DataSource dataSource = null;
		JndiTemplate jndi = new JndiTemplate();
		try {
			dataSource = (DataSource) jndi.lookup("java:comp/env/jdbc/postgres");

		} catch (NamingException e) {
			// logger.error("NamingException for java:comp/env/jdbc/postgres"),
			// e);
		}
		return dataSource;
	}

}
