package com.masai.model;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seed {
     
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer seedId;
	 
	 private String seedName;
	 
	 
	 @JsonFormat(pattern = "dd/mm/yyyy")
	 private Date bloomTime;
	 
	 private String seedDescription;
	 
	 private Integer temperture;
	 
	 private Integer seedPerPacket;
	 
	 private String seedType;
	 
	 private Integer seedStock;
	 
	 private Integer seedCost;
	 
}
