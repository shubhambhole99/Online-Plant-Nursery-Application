package com.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserDTO;
import com.security.service.Authentication;

@RestController
public class AuthenticationController {
      
	  @Autowired
	  private Authentication aservice;
	  
	  @Autoqired
	  private AuthService authServicel;
	
	  @PostMapping("/login")
	  public String loginHandler(@RequestBody UserDTO userDTO) {
		       
		  
		  aservice.re
	  }
}
