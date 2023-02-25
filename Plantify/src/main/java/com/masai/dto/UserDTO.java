package com.masai.dto;

import com.security.model.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
      
	
	private String username;
	
	private String password;
	
	@
	private String userType;
}
