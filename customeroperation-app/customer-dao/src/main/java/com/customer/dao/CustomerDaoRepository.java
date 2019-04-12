package com.customer.dao;
/**
 * @author manoj.kulakarni
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.model.Customer;

@Repository
public interface CustomerDaoRepository extends JpaRepository<Customer, Integer> {

}
