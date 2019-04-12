package com.customer.dao;
/**
 * @author manoj.kulakarni
 */

import java.util.List;

import javax.ws.rs.core.Response;

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

	public Response getCustomerById(int id) {
		Customer customer=customerDaoRepository.findOne(id);
		if(customer==null) {
			 
		return Response.status(Response.Status.NOT_FOUND).build();
		}else {
			
			return Response.ok(customer).build();
		}
	}

	public Customer addCustomer(Customer customer) {
		
		return customerDaoRepository.save(customer);
	}

	public Response updateCustomer(int id, Customer customer) {
		
		Customer returncustomer=customerDaoRepository.findOne(id);
		if(returncustomer==null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}else {
			
			returncustomer.setMobileNo(customer.getMobileNo());
			returncustomer.setAddress(customer.getAddress());
			Customer updatedcustomer=customerDaoRepository.save(returncustomer);
			if(updatedcustomer.equals(customer)) {
				return Response.status(Response.Status.NOT_MODIFIED).build();
			}else {
				return Response.ok(updatedcustomer).build(); 
			}
		}
		
	}

	public Response deleteCustomer(int id) {
		Response response= getCustomerById(id);
		if(response.getStatus()==200) {
			customerDaoRepository.delete(id);
			return Response.ok().build();
		}else {
			return response;
		}
		

	}

	
	

}
