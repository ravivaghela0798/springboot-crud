package com.springbootcrud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcrud.model.Customers;
import com.springbootcrud.repository.CustomerRepository;
import com.springbootcrud.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customers> getallCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customers customer) {
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

}
