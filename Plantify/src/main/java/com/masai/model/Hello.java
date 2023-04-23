package com.masai.model;


//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.data.annotation.Id;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.ElementCollection;
//import jakarta.persistence.Embedded;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.OneToOne;
//import lombok.Data;
//
////Total Repository of Cart Made
////cd.save in cartService impl
////and one to one relationship
//custoer impl saved in add customer
//@Data
////@Entity
//public class Hello{
////	added
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer cartid;
//	
////	fetch=FetchType.EAGER
//	private Integer totalitems=0;
//	
////	@OneToOne
////	@JsonIgnore
////	private Customer customer;
//	
//	private Integer totalprice=0;
//
////	@Embedded
////	@ElementCollection(fetch=FetchType.EAGER)
////	private List<PlantDTO> plant1=new ArrayList<>();
//	
//	@Embedded
//	@ElementCollection(fetch=FetchType.EAGER)
//	private List<Plant> plantlist=new ArrayList<>();
//////	
//////	
//////added
//////	@OneToMany(mappedBy="cart",fetch=FetchType.EAGER)
//	@Embedded
//	@ElementCollection(fetch=FetchType.EAGER)
//	private List<Planter> planterlist=new ArrayList<>();
//	
//	@Embedded
//	@ElementCollection(fetch=FetchType.EAGER)
//	private List<Seed> seedlist=new ArrayList<>();
//
//
//	
//
//	
////	{
////	    "od":{
////	        "totalprice":1,
////	        "totalitems":0,
////	        "plantlist":[]
////	    }
////	}
//}
