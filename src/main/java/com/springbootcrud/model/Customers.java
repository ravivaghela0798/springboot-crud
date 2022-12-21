package com.springbootcrud.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "customer_details")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birthdate")
	private Date dateOfBirth;

	@Column(name = "mobile_no")
	private Long mobile;

	@Column(name = "address_1")
	private String address1;

	@Column(name = "address_2")
	private String address2;

	@Column(name = "age")
	private Integer age;

	@Column(name = "email_id")
	private String email;

}
