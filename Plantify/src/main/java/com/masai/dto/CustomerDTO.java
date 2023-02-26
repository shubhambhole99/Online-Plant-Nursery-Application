package com.masai.dto;

import com.masai.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
     
	
	  private String key;
	  
	  private Customer customer;
}
