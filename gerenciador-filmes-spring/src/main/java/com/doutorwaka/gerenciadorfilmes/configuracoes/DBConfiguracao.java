package com.doutorwaka.gerenciadorfilmes.configuracoes;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfiguracao {

	@Bean
	public DataSource dataSourceConfiguracao() {
		return DataSourceBuilder.create()
			.driverClassName("org.h2.Driver")
			.url("jdbc:h2:mem:testdb")
			.username("admin")
			.password("admin")
			.build();
	}
	
}
