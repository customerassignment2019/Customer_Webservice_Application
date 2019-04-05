package com.customer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public class CustomerDaoImp {

	@Autowired
	CustomerDaoRepository customerDaoRepository;
	public Customer save(Customer customer) {
		return customerDaoRepository.save(customer);
	}
}
