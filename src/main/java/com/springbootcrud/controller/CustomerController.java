package com.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.model.Customers;
import com.springbootcrud.service.CustomerService;

/* 
 * create customer controller for API 
 */
@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/save")
	public Customers saveCustomer(@RequestBody Customers customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/getById/{id}")
	public Customers getCustomerById(@PathVariable("id") Long id) {
		return customerService.getCustomerById(id);
	}

	@GetMapping("/getAll")
	public List<Customers> getAllCustomers() {
		List<Customers> customers = customerService.getAllCustomers();
		return customers;
	}

	@PutMapping("/update/{id}")
	public Customers updateCustomer(@PathVariable(value = "id") Long id, @RequestBody Customers customer) {
		return customerService.updateCustomer(id, customer);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable(value = "id") Long id) {
		return customerService.deleteCustomer(id);
	}
}
