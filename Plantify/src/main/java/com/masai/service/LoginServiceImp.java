package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.CustomerException;
import com.exception.LoginException;
import com.masai.dto.UserDTO;
import com.masai.model.Admin;
import com.masai.model.Customer;
import com.security.model.UserSession;
import com.security.model.UserType;
import com.security.service.Authentication;


@Service
public class LoginServiceImp implements LoginService{
	
	
	@Autowired
	private AdminService aService;
	
	
	@Autowired
	private CustomerService cService;
	
	@Autowired
	private Authentication auth;

	@Override
	public String login(UserDTO userDto) throws LoginException, Exception {
		// TODO Auto-generated method stub
	     if(  userDto.getUserType().equals(UserType.ADMIN)){
	    	 
	    	Admin admin =   aService.getAdminByNameAndPassword(userDto.getUsername(), userDto.getPassword());
	    	
	    	if(admin == null) {
	    		 throw new LoginException("There is no Admin with this username and password");
	    	}else {
	    		return  auth.registerSession(admin.getId(), UserType.ADMIN);
	    	}
	     }else {
	    	Customer c =     cService.getCustomerByUserNameAnsPassword(userDto.getUsername(), userDto.getPassword());
	    	     
	    	if(c == null) {
	    		   throw new CustomerException("There is no Customer with is username and password");
	    	}else
	    	   return	auth.registerSession(c.getCustomerId(), UserType.USER);
	    	     
	     }
	     
	     
	    
		
	}

	@Override
	public String logout(String key) throws Exception {
		// TODO Auto-generated method stub
		
	    boolean result =   auth.destroySession(key);
		
	    
	    if(result) {
	    	 return "logout seccussfully";
	    }else {
	    	 throw new Exception("Oops! logout is failed.");
	    }
		
		
	}
     
	
	
	
}
