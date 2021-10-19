package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Customer;



@Controller
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		List<Customer> customers=customerRepository.findAll();
		model.addAttribute("listCustomers", customers);
		return "customers";//appel la page customers.html
	}
	@RequestMapping(value="/form",method = RequestMethod.GET)
	public String formCustomer(Model model) {
		model.addAttribute("customer",new Customer());
		return "FormCustomer";
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(Model model,Customer customer,BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "FormCustomer";
		customerRepository.save(customer);
		return "Confirmation";
	}
	@RequestMapping(value="/")
	public String home() {
		return "redirect:/index";
	}

}
