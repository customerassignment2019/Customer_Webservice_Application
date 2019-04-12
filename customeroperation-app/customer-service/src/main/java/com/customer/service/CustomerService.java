package com.customer.service;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.customer.model.Customer;

/**
 * @author srinivas.pannur
 * @author manoj.kulakarni
 *
 */
@Service
public interface CustomerService {
	
	// this method is to get all customers
	public List<Customer> getAllCustomers();

	// this method is to get customer using id
	public Response getCustomerById(int id);

	// this method is to add customer
	public Customer addCustomer(Customer customer);

	// this method is to update customer
	public Response updateCustomer(int id, Customer customer);

	// this method is to delete customer
	public Response deleteCustomer(int id);
}
