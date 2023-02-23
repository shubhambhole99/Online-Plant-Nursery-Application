package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
       
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer CustomerId;
	private String username;
	
	private Address address;
	
	private String mobileNo;
	
	private String password;
}