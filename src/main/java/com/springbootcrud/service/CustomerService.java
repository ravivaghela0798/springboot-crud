package com.springbootcrud.service;

import java.util.List;

import com.springbootcrud.model.Customers;

/*
 *  create service interface for define methods without any implementations and business logic
 */

public interface CustomerService {

	Customers saveCustomer(Customers customer);

	Customers getCustomerById(Long id);
	List<Customers> getallCustomers();

	Customers updateCustomer(Long id, Customers customer);


	void deleteCustomer(Long id);
}
