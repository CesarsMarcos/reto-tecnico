package com.reto.tecnico.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;


import io.r2dbc.spi.ConnectionFactory;

@Configuration
//@EnableR2dbcRepositories/*(basePackages = "com.reto.tecnico.repository")*/
public class DataBaseConfig /*extends AbstractR2dbcConfiguration */{
	
    /*@Bean
    @Override
    public H2ConnectionFactory connectionFactory() {
        return new H2ConnectionFactory(
            H2ConnectionConfiguration.builder()
            .url("mem:spring-security;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
              .username("sa")
              .build()
        );
    }*/
    
  @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        var initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
 
        var databasePopulator = new CompositeDatabasePopulator();
        databasePopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        //databasePopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
        initializer.setDatabasePopulator(databasePopulator);
        return initializer;
    }
    
}
