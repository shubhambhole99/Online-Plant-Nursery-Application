package com.masai.dto;

import com.masai.model.Seed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeedDTO {
        
	
	private String key;
	
	private Seed seed;
	
}
