package com.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootcrud.model.Customers;

/* 
 * create repository for storage, retrieval, search, update and delete operation on objects.
 */

public interface CustomerRepository extends JpaRepository<Customers, Long> {

}
