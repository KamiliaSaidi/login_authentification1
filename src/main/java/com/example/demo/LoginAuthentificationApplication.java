package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Customer;

@SpringBootApplication
public class LoginAuthentificationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(LoginAuthentificationApplication.class, args);
		CustomerRepository customerRepository=ctx.getBean(CustomerRepository.class);
//		customerRepository.save(new Customer("Kamilia","riad bouskoura","0661494559","09/06/1985"));
//		customerRepository.save(new Customer("wiam","riad bouskoura","0661494559","18/04/2012"));
//		customerRepository.save(new Customer("zainab","riad bouskoura","0661494559","23/06/2014"));
//		customerRepository.save(new Customer("Amine","riad bouskoura","0661494559","12/06/2018"));
		customerRepository.findAll().forEach(p->System.out.println(p.getName()));
		
		}

}
