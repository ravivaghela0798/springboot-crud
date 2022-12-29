package com.springbootcrud.payloads;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.springbootcrud.enums.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

		private Long id;
		
		@Size(message = "{validation.firstname}")
		private String firstName;

		@Size(message = "{validation.lastname}")
		private String lastName;

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date dateOfBirth;

		private String mobile;

		private String address1;

		private String address2;

		private Integer age;

		@Enumerated(EnumType.STRING)
		private Gender gender;

		private String email;

}
