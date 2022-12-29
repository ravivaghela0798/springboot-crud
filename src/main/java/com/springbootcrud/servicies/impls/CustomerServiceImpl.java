package com.springbootcrud.servicies.impls;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcrud.exceptions.ResourceNotFoundException;
import com.springbootcrud.models.Customer;
import com.springbootcrud.payloads.CustomerDto;
import com.springbootcrud.repositories.CustomerRepository;
import com.springbootcrud.servicies.CustomerService;

/*
 * create CustomerServiceImpl and implements CustomerService interface and override all the methods and
 * provide implementation and business logic 
 */

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		Customer customer = this.dtoToCustomer(customerDto);
		Customer customerResponseObject = this.customerRepository.save(customer);
		return this.customerToDto(customerResponseObject);	
	}

	@Override
	public CustomerDto getCustomerById(Long id) {
		Customer customerObject = this.customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", " Id", id));
		return this.customerToDto(customerObject);
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customerList = this.customerRepository.findAll();
		List<CustomerDto> dtoList = customerList.stream().map(customer -> this.customerToDto(customer)).collect(Collectors.toList());
		return dtoList;
	}

	@Override
	public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
		CustomerDto existedCustomer = this.getCustomerById(id);
		Customer customerObject = this.dtoToCustomer(existedCustomer);
		Customer updatedCustomer = this.customerRepository.save(customerObject);
		return this.customerToDto(updatedCustomer);
		
	}

	@Override
	public void deleteCustomer(Long id) {
		CustomerDto customerDto = this.getCustomerById(id);
		customerRepository.deleteById(customerDto.getId());
	}
	
	public Customer dtoToCustomer(CustomerDto customerDto) {
		Customer customerModelObject = new Customer();
		BeanUtils.copyProperties(customerDto, customerModelObject);
		return customerModelObject;
	}
	
	public CustomerDto customerToDto(Customer customerObject) {
		CustomerDto customerDto = new CustomerDto();
		BeanUtils.copyProperties(customerObject, customerDto);
		return customerDto;
	}

}
