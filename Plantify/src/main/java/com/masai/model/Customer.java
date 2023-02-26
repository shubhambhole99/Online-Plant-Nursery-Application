package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
       
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CustomerId;
	private String username;
	
	
	@Embedded
	private Address address;
	
	private String mobileNo;
	
	private String password;
	
	@Embedded
	private Cart od;
	
	
	@OneToMany
	private List<Orders> ol=new ArrayList<>();
}
