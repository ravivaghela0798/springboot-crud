package com.springbootcrud.service;

import java.util.List;

import com.springbootcrud.model.Customers;

/*
 *  create service interface for define methods without any implementations and business logic
 */

public interface CustomerService {

	Customers saveCustomer(Customers customer);

	Customers getCustomerById(Long id);

	List<Customers> getAllCustomers();

	Customers updateCustomer(Long id, Customers customer);

	String deleteCustomer(Long id);
}
