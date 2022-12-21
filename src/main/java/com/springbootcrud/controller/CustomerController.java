package com.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.model.Customers;
import com.springbootcrud.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/saveCustomer")
	public void saveCustomer(@RequestBody Customers customer) {
		customerService.saveCustomer(customer);
	}

	@GetMapping("/getAllCustomers")
	public List<Customers> getAllCustomers() {
		List<Customers> customers = customerService.getallCustomers();
		return customers;
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable(value = "id") Long id) {
		customerService.deleteCustomer(id);
	}
}
