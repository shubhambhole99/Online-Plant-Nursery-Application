package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.LoginException;
import com.masai.dto.UserDTO;
import com.masai.service.LoginService;
import com.security.service.Authentication;

@RestController
public class LoginController {
      
	  @Autowired
	  private Authentication aservice;
	  
	 
	  @Autowired
	  private LoginService loginService;
	
	  @PostMapping("/login")
	  public ResponseEntity<String> loginHandler(@RequestBody UserDTO userDTO) throws LoginException, Exception {
		       
		   String key =  loginService.login(userDTO);
		      
		  
		    
		 
		  
		  return new ResponseEntity<String>(key, HttpStatus.ACCEPTED);
	  }
	  
	  
	  @PostMapping("/logout")
	  public ResponseEntity<String> logoutHandler(@RequestBody String key) throws LoginException, Exception {
		       
		   String result =  loginService.logout(key);
		      
		  
		    
		 
		  
		  return new ResponseEntity<String>(result, HttpStatus.OK);
	  }
}
