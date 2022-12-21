package com.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootcrud.model.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

}
