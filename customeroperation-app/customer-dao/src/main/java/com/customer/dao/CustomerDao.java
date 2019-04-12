package com.customer.dao;
/**
 * @author manoj.kulakarni
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public class CustomerDao {
	
	@Autowired
private	CustomerDaoRepository customerDaoRepository;
	
	public List<Customer> getAllCustomers() {
		
		return customerDaoRepository.findAll();
	}

	public Customer getCustomerById(int id) {
		
		return customerDaoRepository.findOne(id);
	}

	public Customer addCustomer(Customer customer) {
		
		return customerDaoRepository.save(customer);
	}

	public Customer updateCustomer(int id, Customer customer) {
		
		Customer returncustomer=customerDaoRepository.findOne(id);
		
		returncustomer.setMobileNo(customer.getMobileNo());
		returncustomer.setAddress(customer.getAddress());
		Customer updatedcustomer=customerDaoRepository.save(returncustomer);
		
		return updatedcustomer;
	}

	public int deleteCustomer(int id) {
		int res=0;
		customerDaoRepository.delete(id);
		res=1;
		return res;
	}

	
	

}
