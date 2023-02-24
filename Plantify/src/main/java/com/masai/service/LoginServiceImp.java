package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.CustomerException;
import com.masai.dto.UserDTO;
import com.security.model.UserType;


@Service
public class LoginServiceImp implements LoginService{
	
	
	@Autowired
	private AdminService

	@Override
	public String login(UserDTO userDto) throws CustomerException {
		// TODO Auto-generated method stub
	     if(  userDto.getUserType().equals(UserType.ADMIN)){
	    	 
	    	 
	    	 
	     }
	     
	     
	    
		
	}
     
	
	
	
}
