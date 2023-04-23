package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer plant_id;
	
	@NotNull(message="Plant Name Cannot be null")
	@Size(min=1,message = "Name should be greater than 1")
	private String plantname;
	
	@NotNull(message="Time cannot be Null")
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate bloomtime;
	
	@NotNull(message="Temperature Cannot be Null")
	private Integer temperature;
	
	@NotNull(message="Plant_Height Cannot be Null")
	@Min(value=1,message="Min Height should be greater than 1cm")
	private Integer plantheight_cm;
	
	@NotNull(message="Plant Type Cannot be Null")
	private String planttype;
	
	
	@NotNull(message="Plant Price cannot be Null")
	@Min(value=0,message="Stock should be greater than 0")
	private Integer plantcost;
	
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Orders> ol=new ArrayList<>();
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Cart> cart=new ArrayList<>();
	
	
//	{
//	    "plantname":"shubham",
//	    "bloomtime":"01/02/1999",
//	    "temperature":3,
//	    "plantheight_cm":50,
//	    "planttype":"Fruit",
//	    "plantstock":20,
//	    "plantcost":100
//	}

	
	
}
