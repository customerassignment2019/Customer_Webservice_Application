package com.customer.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.service.CustomerServiceImpl;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	public CustomerController() {
		
	}
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerServiceImpl.addCustomer(customer);
		
		return customer;
		
	}
	
	@PutMapping("/updateCustomer/{id}")
	public int updateCustomer(@RequestBody Customer customer,@PathVariable int id) {
		int updateCustomer = customerServiceImpl.updateCustomer(id, customer);
		return updateCustomer;
	
}
}
