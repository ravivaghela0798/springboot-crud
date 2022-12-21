package com.springbootcrud.service;

import java.util.List;

import com.springbootcrud.model.Customers;

public interface CustomerService {

	void saveCustomer(Customers customer);

	List<Customers> getallCustomers();

	void deleteCustomer(Long id);

}
