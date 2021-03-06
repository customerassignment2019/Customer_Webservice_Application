package com.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Customer")
public class Customer {

	public Customer() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;
	@Column(name = "customer_name") 
	@NotEmpty(message="Customer Name is empty")
	private String customerName;
	@Column(name = "customer_age")
	@Min(18)
	private int age;
	@Column(name = "customer_emailid")
	@Email(message="Customer Email id is not valid")
	private String emailId;
	@Column(name = "customer_address")
	private String address;
	@Column(name = "customer_mobileno")
	@Max(value=10)
	private int mobileNo;

	
	
	public Customer(int id, String customerName, int age, String emailId, String address, int mobileNo) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.age = age;
		this.emailId = emailId;
		this.address = address;
		this.mobileNo = mobileNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

}
