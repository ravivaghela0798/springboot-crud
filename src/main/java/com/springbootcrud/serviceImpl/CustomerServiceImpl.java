package com.springbootcrud.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcrud.model.Customers;
import com.springbootcrud.repository.CustomerRepository;
import com.springbootcrud.service.CustomerService;

/*
 * create CustomerServiceImpl and implements CustomerService interface and override all the methods and
 * provide implementation and business logic 
 */

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customers saveCustomer(Customers customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customers getCustomerById(Long id) {
		Customers customerObject = null;
		Optional<Customers> optionalCustomer = customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			customerObject = optionalCustomer.get();
		} else {
			throw new RuntimeException("Customer not found for id = " + id);
		}
		return customerObject;
	}

	@Override
	public List<Customers> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customers updateCustomer(Long id, Customers customer) {
		Customers customerObject = getCustomerById(id);
		BeanUtils.copyProperties(customer, customerObject);
		return customerRepository.save(customerObject);
	}

	@Override
	public String deleteCustomer(Long id) {
		customerRepository.deleteById(id);
		return "Customer Deleted";
	}

}
