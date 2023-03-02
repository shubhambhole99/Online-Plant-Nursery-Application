package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.model.Orders;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
//@NoArgsConstructor
@Entity
@Table(name="PLANTERS")
public class Planter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="planterId")
	@Min(value=1, message = "Planter id must not be Negative or Zero")
	private Integer planterId;
	
	@Column(name="planterHeight")
	@Max(value=100,message="Planter hieght must be between 1 to 100")
	@NotNull(message = "Planter Height must not be null")
	private Integer planterHeight;
	
	@Column(name="planterCapacity")
	@Min(value=1, message = "Planter capacity  must not Negative or zero")
	@Max(value=10000, message = "Planter capacity should be below 10000")
	@NotNull(message = "Planter Capacity must not be null")
	private Integer planterCapacity;
	
	@Min(value=1, message = "Drainage Holes must not Negative or zero")
	@Column(name="drainageHoles")
	@NotNull(message = "Planter drainageHoles must not be null")
	private Integer drainageHoles;
	
	@Column(name="planterColor")
	@Size(min=2, max=25, message = "Planter color size must be between 2 to 25")
	@NotNull(message = "Planter color must not be null")
	private String planterColor;
	
	@Column(name="planterShape")
	@Size(min=2, max=25, message = "Planter shape size must be between 2 to 25")
	@NotNull(message = "Planter shape must not be null")
	private String planterShape;
	
	@Column(name="planterStock")
	@Min(value=1, message = "Planter stock  must be above 1")
	@NotNull(message = "Planter stock must not be null")
	private Integer planterStock;
	
	@Column(name="planterCost")
	@Min(value=50, message = "Planter cast price must be above 50")
	@NotNull(message = "Planter cost must not be null")
	private Integer planterCost;
	

	@ManyToMany
	@JsonIgnore
	private List<Orders> ol=new ArrayList<>();
//	@JsonIgnore
//	@OneToOne
//	private Plant plant;
//	
//	@JsonIgnore
//	@OneToOne
//	private Seed seed;
//
//	
//	@JsonIgnore
//	private Integer cartId;
//	

}
