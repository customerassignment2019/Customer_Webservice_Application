package com.customer.ws;
/**
 * @author manoj.kulakarni
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.service.CustomerServiceForJPA;

@RestController
/*@Path("/customer")*/
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceForJPA customerServiceImpl;
	
	public CustomerController() {
		
	}
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerServiceImpl.addCustomer(customer);
		
		return customer;
		
	}
	
	@PutMapping("/updateCustomer/{id}")
	public Customer updateCustomer(@RequestBody Customer customer,@PathVariable int id) {
		Customer updateCustomer = customerServiceImpl.updateCustomer(id, customer);
		return updateCustomer;
	
}
/*	@GET
	@Path("/getCustomer/{id}")
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	public Customer getCustomerById(@PathParam("id") int id) {
		Customer updateCustomer = customerServiceImpl.getCustomerById(id);
		return updateCustomer;
	}*/
	@GetMapping("/getCustomerById/{id}")
	public Customer getCustomerById(@PathVariable(value = "id") int id) {
		Customer customer = customerServiceImpl.getCustomerById(id);
		
		return customer;
	}
	@DeleteMapping("/deleteCustomer/{id}")
	public int deleteCustomer(@PathVariable(value = "id") int id) {
		int response = customerServiceImpl.deleteCustomer(id);
		
		return response;
	}
}
