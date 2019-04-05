package com.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.Customer;

public interface CustomerDaoRepository  extends JpaRepository<Customer, Integer>{
	
	

}
