package com.customer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.dao.CustomerDaoImp;
import com.customer.model.Customer;

@Service
public class CustomerServiceImpl  {

	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private CustomerDaoImp customerDao;

	
	@Transactional
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.save(customer);
	}

	
	@Transactional
	public Map<String, Object> updateCustomer(int id, Customer customer) {
		Map<String,Object> map=new HashMap<>();
		int res=customerDao.updateCustomer( id, customer);
		if(res>0) {
			map.put("message", "Customer_Successfully_Updated");
		}else {
			map.put("message", "Error");
			
		}
		return map;
	}
	@Transactional
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(id);
		
	}
	
	@Transactional
	public Map<String,Object> deleteCustomer(int id) {
		Map<String,Object> map=new HashMap<>();
		int res=customerDao.deleteCustomer(id);
		if(res>0) {
			map.put("message", "Customer_Successfully_Deleted");
		}else {
			map.put("message", "Error");
			
		}
		return map;
	}

}
