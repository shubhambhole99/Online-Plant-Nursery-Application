package com.masai.model;

import java.sql.Date;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Seed {
     
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer seedId;
	 
	 @NotNull(message="Plant Name Cannot be null")
	@Size(min=1,message = "Name should be greater than 1")
	 private String seedName;
	 
	 @NotNull(message="Time cannot be Null")
		@JsonFormat(pattern="dd/MM/yyyy")
		@Past
	 private Date bloomTime;
	 
	 private String seedDescription;
	 
	 @NotNull(message="Temperature Cannot be Null")
	 private Integer temperture;
	 
	 private Integer seedPerPacket;
	 
	@NotNull(message="Plant Type Cannot be Null")
	 private String seedType;
	 
	 @NotNull(message="Plant Stock Cannot be Null")
		@Min(value=0,message="Stock should be greater than 0")
	 private Integer seedStock;
	 
	 @NotNull(message="Plant Price cannot be Null")
		@Min(value=0,message="Stock should be greater than 0")
	 private Integer seedCost;
	 
}
