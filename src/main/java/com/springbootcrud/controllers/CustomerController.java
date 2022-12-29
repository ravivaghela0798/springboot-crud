package com.springbootcrud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.models.Customer;
import com.springbootcrud.payloads.ApiResponse;
import com.springbootcrud.payloads.CustomerDto;
import com.springbootcrud.servicies.CustomerService;

import jakarta.validation.Valid;

/* 
 * create customer controller for API 
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/save")
	public ResponseEntity<CustomerDto> saveCustomer(@Valid @RequestBody CustomerDto customerDto) {
		CustomerDto createdDto = null;
		try {
			createdDto = customerService.saveCustomer(customerDto);
			return new ResponseEntity<>(createdDto, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id) {
		CustomerDto customerDto = customerService.getCustomerById(id);
		if (customerDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(customerDto));

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CustomerDto>> getAllCustomers() {
		List<CustomerDto> customerDtoList = customerService.getAllCustomers();
		if (customerDtoList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(customerDtoList));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@Valid @PathVariable(value = "id") Long id,
			@RequestBody CustomerDto customerDto) {
		try {
			this.customerService.updateCustomer(id, customerDto);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable(value = "id") Long id) {
		try {
				this.customerService.deleteCustomer(id);
				return new ResponseEntity<ApiResponse>(new ApiResponse("Customer Deleted Succesfully", true),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
