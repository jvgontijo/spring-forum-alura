package com.alura.forum.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alura.forum.modelo.Usuario;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	
	@Bean
	public Docket forumApi() {
		return new Docket(DocumentationType.SWAGGER_2) //tipo da documentação
				.select() 
				.apis(RequestHandlerSelectors.basePackage("com.alura.forum")) //a partir de qual pacote vai ler
				.paths(PathSelectors.ant("/**"))  //quais endpoints ele vai analisar (/** = todos)
				.build()
				.ignoredParameterTypes(Usuario.class) //ignora todas os endpoints com a classe usuário
				.globalOperationParameters(Arrays.asList( //para adicionar parametros globais para ser apresentado em todos endpoints
						new ParameterBuilder() //passando o parametro
						.name("Authorization") //nome do cabeçalho
						.description("Header para token JWT")
						.modelRef(new ModelRef("string"))
						.parameterType("header") //tipo - cabeçalho
						.required(false)
						.build()));
	}
}
