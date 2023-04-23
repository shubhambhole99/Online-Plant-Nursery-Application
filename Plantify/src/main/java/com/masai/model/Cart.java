package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartid;
	
	private Integer totalprice=0;
	
	private Integer totalitems=0;

	
	
	@OneToOne
	@JsonIgnore
	private Customer customer;
	
	
//	@Embedded
//	@ElementCollection(fetch=FetchType.EAGER)
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Plant> plantlist=new ArrayList<>();
	
	
//	@Embedded
//	@ElementCollection(fetch=FetchType.EAGER)
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Planter> planterlist=new ArrayList<>();
	
//	@Embedded
//	@ElementCollection(fetch=FetchType.EAGER)
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Seed> seedlist=new ArrayList<>();
	
	
}
