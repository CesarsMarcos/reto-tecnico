package com.reto.tecnico.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.reto.tecnico"))
	      //.paths(PathSelectors.ant("**"))
	      .build()
	      .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "Apis Rest - Tipo de Cambio", 
	      "Calcular el tipo de cambio de una moneda", 
	      "", 
	      "", 
	      new Contact("César Marcos", "https://www.linkedin.com/in/cesar-marcos/", "cesarmarcosramos@gmail.com"), 
	      "", "", Collections.emptyList());
	}
}

	
