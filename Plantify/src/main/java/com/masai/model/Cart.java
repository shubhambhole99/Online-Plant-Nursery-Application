package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.model.Planter;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
public class Cart{
	
	private Integer totalprice=0;
	private Integer totalitems=0;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JsonIgnore
//	private Customer customer;
	
	@Embedded
	@ElementCollection
	private List<Plant> plantlist=new ArrayList<>();
//	
//	

	@Embedded
	@ElementCollection
	private List<Planter> planterlist=new ArrayList<>();
	
	@Embedded
	@ElementCollection
	private List<Seed> seedlist=new ArrayList<>();



	

	
//	{
//	    "od":{
//	        "totalprice":1,
//	        "totalitems":0,
//	        "plantlist":[]
//	    }
//	}
}
