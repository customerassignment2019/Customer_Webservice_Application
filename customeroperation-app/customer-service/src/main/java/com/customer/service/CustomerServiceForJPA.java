package com.customer.service;
/**
 * @author manoj.kulakarni
 */
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dao.CustomerDao;
import com.customer.model.Customer;
@Service
public class CustomerServiceForJPA implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDao.getAllCustomers();
	}

	@Override
	public Response getCustomerById(int id) {
		
		return customerDao.getCustomerById(id);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerDao.addCustomer(customer);
	}

	@Override
	public Response updateCustomer(int id, Customer customer) {
		
		return customerDao.updateCustomer(id,customer);
	}

	@Override
	public Response deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}

}
