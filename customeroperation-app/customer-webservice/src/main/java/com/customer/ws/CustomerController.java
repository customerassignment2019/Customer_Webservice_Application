package com.customer.ws;
import javax.ws.rs.core.Response;

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
	
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerServiceImpl.addCustomer(customer);
		
		return customer;
		
	}
	
	@PutMapping("/updateCustomer/{id}")
	public Response updateCustomer(@RequestBody Customer customer,@PathVariable int id) {
		Response updateCustomer = customerServiceImpl.updateCustomer(id, customer);
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
	public Response getCustomerById(@PathVariable(value = "id") int id) {
		Response customer = customerServiceImpl.getCustomerById(id);
		
		return customer;
	}
	@DeleteMapping("/deleteCustomer/{id}")
	public Response deleteCustomer(@PathVariable(value = "id") int id) {
		Response response = customerServiceImpl.deleteCustomer(id);
		
		return response;
	}
}
