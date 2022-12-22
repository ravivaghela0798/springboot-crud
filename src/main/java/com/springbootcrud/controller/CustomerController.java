package com.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.model.Customers;
import com.springbootcrud.service.CustomerService;

/* 
 * create customer controller for API 
 */

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/saveCustomer")
	public String saveCustomer(@RequestBody Customers customer) {
		customerService.saveCustomer(customer);
		return "Add " + customer.getFirstName() + " " + customer.getLastName() + "customer list";
	}

	@GetMapping("/getCustomerById/{id}")
	public Customers getCustomerById(@PathVariable("id") Long id) {
		return customerService.getCustomerById(id);
	}

	@GetMapping("/getAllCustomers")
	public List<Customers> getAllCustomers() {
		List<Customers> customers = customerService.getallCustomers();
		return customers;
	}

	@PutMapping("/updateCustomer/{id}")
	public Customers updateCustomer(@PathVariable(value = "id") Long id, @RequestBody Customers customer) {
		return customerService.updateCustomer(id, customer);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable(value = "id") Long id) {
		customerService.deleteCustomer(id);
	}
}
