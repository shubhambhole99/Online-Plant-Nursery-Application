package com.masai.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Embeddable
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer plant_id;
	
	@NotNull(message="Plant Name Cannot be null")
	@Size(min=1,message = "Name should be greater than 1")
	private String plantname;
	
	@NotNull(message="Time cannot be Null")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Past
	private LocalDate bloomtime;
	
	@NotNull(message="Temperature Cannot be Null")
	private Integer temperature;
	
	@NotNull(message="Plant_Height Cannot be Null")
	@Min(value=1,message="Min Height should be greater than 1cm")
	private Integer plantheight_cm;
	
	@NotNull(message="Plant Type Cannot be Null")
	private String planttype;
	
	@NotNull(message="Plant Stock Cannot be Null")
	@Min(value=0,message="Stock should be greater than 0")
	private Integer plantstock;
	
	@NotNull(message="Plant Price cannot be Null")
	@Min(value=0,message="Stock should be greater than 0")
	private Integer plantcost;
	
	
	
	
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
