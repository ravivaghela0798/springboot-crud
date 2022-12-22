package com.springbootcrud.model;

import java.sql.Date;

/* 
 * create customer entity and create columns, 
 * for getter, setter and constructors use Lombok Project 
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * create Customers class for creating object of customer and store in database
 * for getter, setter and constructors use lombok project 
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_details")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(name = "birthdate", nullable = false)
	private Date dateOfBirth;

	@Column(name = "mobile_no", nullable = false, length = 17, unique = true)
	private String mobile;

	@Column(name = "address_1", nullable = false, length = 100)
	private String address1;

	@Column(name = "address_2", nullable = false, length = 100)
	private String address2;

	@Column(name = "age", nullable = false, length = 3)
	private Integer age;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "email_id", nullable = false, length = 50, unique = true)
	private String email;

}
