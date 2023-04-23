package com.masai.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seed {
     
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer seedId;
	 
	 @NotNull(message="Plant Name Cannot be null")
	@Size(min=1,message = "Name should be greater than 1")
	 private String seedName;
	 
	 @NotNull(message="Time cannot be Null")
		@JsonFormat(pattern="dd/MM/yyyy")
	 private Date bloomTime;
	 
	 private String seedDescription;
	 
	 @NotNull(message="Temperature Cannot be Null")
	 private Integer temperture;
	 
	 private Integer seedPerPacket;
	 
	@NotNull(message="Plant Type Cannot be Null")
	 private String seedType;
	 
	 
	 @NotNull(message="Plant Price cannot be Null")
		@Min(value=0,message="Stock should be greater than 0")
	 private Integer seedCost;
	 
	 
		@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
		@JsonIgnore
		private List<Orders> ol=new ArrayList<>();
	 	
	 	
		@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
		@JsonIgnore
		private List<Cart> cart=new ArrayList<>();
}
