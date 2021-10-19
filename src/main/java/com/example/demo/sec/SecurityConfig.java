package com.example.demo.sec;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
	
//		auth.jdbcAuthentication()
//		   .dataSource(dataSource)
//		   .usersByUsernameQuery("select login as principal,pass as credentials,active from users where login=?")
//		   .authoritiesByUsernameQuery("select login as principal, role as role from users_role where login=?")
//		   //.passwordEncoder(new Md4PasswordEncoder())
//		   .rolePrefix("ROLE_");
		
		auth.inMemoryAuthentication()
		   .withUser("admin").password("1234").roles("USER","ADMIN");
		auth.inMemoryAuthentication()
		   .withUser("user").password("1234").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/index").hasRole("USER");
		http.authorizeRequests().antMatchers("/form","/save").hasRole("ADMIN");
	}
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}

