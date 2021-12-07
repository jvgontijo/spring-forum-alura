package com.alura.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
	
	//configurações de autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
	
	//configurações de autorização (perfis de acesso)
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/topicos").permitAll()
			//para liberar outras, continua com antMatchers
			.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
			.anyRequest().authenticated() //acesso aos outros endpoints só se tiver autenticado
			.and().formLogin(); //gera formulario padrão de login
	}
	
	//configurações de recursos estáticos (js, css, imagens, etc)
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
}
