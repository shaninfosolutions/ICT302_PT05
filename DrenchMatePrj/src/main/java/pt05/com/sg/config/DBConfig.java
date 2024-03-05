package pt05.com.sg.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import jakarta.persistence.EntityManagerFactory;
import mmk.com.sg.aes.EncryptDecrypt;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="drenchmateEntityManagerFactory",
						transactionManagerRef="drenchmateTransactionManager",
						basePackages= {"pt05.com.sg.data.repository"})
public class DBConfig {
	
	@Value("${spring.datasource.driver-class-name}")
	private   String driverClassName;
	
	@Value("${spring.datasource.url}")
	private   String url;
	
	@Value("${spring.datasource.username}")
	private   String username;
	
	@Value("${spring.datasource.password}")
	private   String password;
	
	
	@Primary
	@Bean(name="drenchmate")
	public DataSource drenchMate() {
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(EncryptDecrypt.decrypt(password));
		
		return dataSource;
	}
	
	@Primary
	@Bean(name="drenchmateEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean drenchMateEntityManagerFactory(EntityManagerFactoryBuilder builder,
				@Qualifier("drenchmate") DataSource drenchmate) {
		
		return builder.dataSource(drenchmate)
				.packages("pt05.com.sg.data.entity")
				.persistenceUnit("dm")
				.build();
		
	}
	
	@Primary
	@Bean(name="drenchmateTransactionManager")
	public PlatformTransactionManager drenchmateTransactionManager(
			@Qualifier("drenchmateEntityManagerFactory") EntityManagerFactory drenchmateEntityManagerFactory) {
		return new JpaTransactionManager(drenchmateEntityManagerFactory);
	}
	
	
	

}
