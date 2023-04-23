package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
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
	
	@Column(unique = true)
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	


	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Orders> ol=new ArrayList<>();
	
//	@Embedded
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Cart od;
	
//	@OneToOne
//	private Hello hi;
	
	@NotNull
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",fetch=FetchType.EAGER)
	private List<Authority> authorities = new ArrayList<>();
	
}
