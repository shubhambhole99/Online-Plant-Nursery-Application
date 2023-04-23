package com.masai.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	
//	
//	@Embedded
//	@ElementCollection(fetch=FetchType.EAGER)
//	private List<PlantDTO> plantdtob=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
//	private HashMap<Plant,Integer> hm=new HashMap<>();
	private List<Plant> plantsbought=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Planter> planterbought=new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Seed> seedbought=new ArrayList<>();
//	
//	


	
}
