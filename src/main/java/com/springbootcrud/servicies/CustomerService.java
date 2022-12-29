package com.springbootcrud.servicies;

import java.util.List;

import com.springbootcrud.payloads.CustomerDto;

/*
 *  create service interface for define methods without any implementations and business logic
 */

public interface CustomerService {

	CustomerDto saveCustomer(CustomerDto customerRequest);

	CustomerDto getCustomerById(Long id);

	List<CustomerDto> getAllCustomers();

	CustomerDto updateCustomer(Long id, CustomerDto customerRequest);

	void deleteCustomer(Long id);
}
