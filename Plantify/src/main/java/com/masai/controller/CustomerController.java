package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.CustomerException;
import com.exception.UserSessionException;
import com.masai.dto.CustomerDTO;
import com.masai.dto.KeyDTO;
import com.masai.model.Customer;
import com.masai.service.CustomerService;
import com.security.model.UserSession;
import com.security.model.UserType;
import com.security.service.Authentication;

@RestController
@RequestMapping("/customer")
public class CustomerController {
         
	   @Autowired
	   private CustomerService cService;
	   
	   
	   @Autowired
	   private Authentication auth;
	
	
	  @PostMapping("/registercustomer")
	  public ResponseEntity<String> createCustomerHandler(@RequestBody Customer crDto) {
		  
		   String key =     cService.addCustomer(crDto);
		     
		 return new ResponseEntity<String>(key, HttpStatus.ACCEPTED);
	  }
	  
	  
	  @PostMapping("/getcustomerdetailbykey")
	  public ResponseEntity<Customer> getCustomerHandler(@RequestBody KeyDTO keyDto) throws Exception{
		        
		  
		  UserSession uSession =   auth.authenticate(keyDto.getKey());
		  
		         
		  if(uSession.getUser().equals(UserType.USER)) {
			           
			   return new ResponseEntity<Customer>( cService.getCustomerById(uSession.getUserId()), HttpStatus.ACCEPTED);
		  }else {
			     throw new UserSessionException("Oops! You are not logged in");
		  }
	  }
	  
	  
	 
	  
	  @PutMapping("/updatecustomer")
	  public ResponseEntity<Customer>  updateCustomerHandler(@RequestBody CustomerDTO customerDto) throws Exception{
		         
		  UserSession uSession =   auth.authenticate(customerDto.getKey());
		  
	         
		  if(uSession.getUser().equals(UserType.USER)) {
			      Customer c =  customerDto.getCustomer();
			      
			       if(c.getCustomerId() == null || c.getCustomerId() == uSession.getUserId()) {
			    	   c.setCustomerId(uSession.getUserId());
			    	   
			    	  
			    	   return new ResponseEntity<Customer>(  cService.updateCustomer(c), HttpStatus.ACCEPTED);
			       }else {
			    	    throw new CustomerException("Oops! Wrong customer id is passed.");
			       }
			  
		  }else {
			     throw new UserSessionException("Oops! You are not logined");
		  }
		  
	  }
	
	  
}
