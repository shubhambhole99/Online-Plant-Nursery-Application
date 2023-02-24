package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.dto.UserDTO;
import com.security.service.Authentication;

@RestController
public class LoginController {
      
	  @Autowired
	  private Authentication aservice;
	  
	 
	
	  @PostMapping("/login")
	  public ResponseEntity<String> loginHandler(@RequestBody UserDTO userDTO) {
		       
		  
		 
		  
		  return new ResponseEntity<String>("hello", HttpStatus.ACCEPTED);
	  }
}
