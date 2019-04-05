package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dao.CustomerDaoRepository;
import com.customer.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private CustomerDaoRepository customerDao;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.save(customer);
	}

	@Override
	public int updateCustomer(int id, Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

}
