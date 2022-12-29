package com.springbootcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootcrud.models.Customer;

/* 
 * create repository for storage, retrieval, search, update and delete operation on objects.
 */

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
