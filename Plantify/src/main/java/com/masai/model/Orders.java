package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_id;
	private Integer customer_id;
//	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate orderdate;
	private Integer totalprice=0;
	private Integer totalitems;
	
	
	@Embedded
	@ElementCollection
	private List<Plant> plantsbought=new ArrayList<>();
}
