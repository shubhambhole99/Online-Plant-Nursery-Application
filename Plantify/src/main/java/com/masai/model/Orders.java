package com.masai.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_id;
	
	
	
	@ManyToOne
	@JsonIgnore
	private Customer cus;
//	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate orderdate;
	private Integer totalprice=0;
	private Integer totalitems;
	
	
	@ManyToMany
	private List<Plant> plantsbought=new ArrayList<>();
	
	@ManyToMany
	private List<Planter> planterbought=new ArrayList<>();

	@ManyToMany
	private List<Seed> seedbought=new ArrayList<>();
//	
//	

	
}
