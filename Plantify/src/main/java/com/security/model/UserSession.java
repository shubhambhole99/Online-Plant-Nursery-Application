package com.security.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {
       
	
	
	private Integer id;
	
	private UserType user;
	
	private String Sessionkey;
	
	private Integer userId;
	
	
}
