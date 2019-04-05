package com.customer.service;

import com.customer.model.Customer;

/**
 * @author srinivas.pannur
 *
 */
public interface CustomerService {
//this method is to add customer
	public Customer addCustomer(Customer customer);

//this method is to update customer
	public int updateCustomer(int id, Customer customer);
}
