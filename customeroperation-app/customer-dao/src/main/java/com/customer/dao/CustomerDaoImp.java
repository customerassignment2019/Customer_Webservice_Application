package com.customer.dao;
/**
 * @author manoj.kulakarni
 */
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public class CustomerDaoImp {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Customer save(Customer customer) {
		
		//return customerDaoRepository.save(customer);
		return customer;
	}

	public Customer getCustomerById(int id) {
		Customer customer=new Customer();
		try {
			
			Map<String ,Object>returnMap =jdbcTemplate.queryForMap("select * from customer where customer_id="+id+"");
			System.out.println(returnMap);
			
			customer.setId(Integer.parseInt(returnMap.get("customer_id").toString()));
			customer.setCustomerName(returnMap.get("customer_name").toString());
			customer.setAge(Integer.parseInt(returnMap.get("customer_age").toString()));
			customer.setEmailId(returnMap.get("customer_emailid").toString());
			customer.setAddress(returnMap.get("customer_address").toString());
			customer.setMobileNo(Integer.parseInt(returnMap.get("customer_mobileno").toString()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return customer;
	}

	public int updateCustomer(int id, Customer customer) {
		// TODO Auto-generated method stub
		int check=0;
		try {
		 check=jdbcTemplate.update("update customer set customer_address='"+customer.getAddress()+"', customer_mobileno='"+customer.getMobileNo()+"',customer_emailid='"+customer.getEmailId()+"' where id="+id+"");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return check;
	}

	public int deleteCustomer(int id) {
		int check=0;
		try {
		 check=jdbcTemplate.update("delete from  customer where id="+id+"");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return check;
	}
}
