package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.repository.CustomerDao;
import com.masai.service.CustomerService;

@RestController
@RequestMapping("/customer")
@EnableMethodSecurity
public class CustomerController {
         
	   @Autowired
	   private CustomerService cService;
	   
	   @Autowired
		private PasswordEncoder passwordEncoder;
	   
	  @Autowired
	  private CustomerDao cuds;
	   
	   
	  @PostMapping("/registercustomer")
	  public ResponseEntity<Customer> createCustomerHandler(@RequestBody Customer cus) {

		  cus.setPassword(passwordEncoder.encode(cus.getPassword()));
		  
		   Customer cust =     cService.addCustomer(cus);
		     
		 return new ResponseEntity<>(cust, HttpStatus.ACCEPTED);
	  }
	  
	  
//	  {
//	        "name": "ram",
//	        "email": "ram@gmail.com",
//	        "password": "1234",
//	        "address": "delhi",
//	        "authorities":[
//	            {
//	                "name": "ROLE_USER"
//	            },
//	            {
//	                "name": "ROLE_ADMIN"
//	            }
//	        ]
//	    }
	  
	  
//	  {
//		  "username": "ram",
//		  "address": {
//		    "city": "string",
//		    "state": "string",
//		    "country": "string"
//		  },
//		  "mobileNo": "string",
//		  "email": "ram@gmail.com",
//		  "password": "1234",
//		  "authorities": [
//		  {
//		"name": "ROLE_USER"
//		},
//		{
//		"name": "ROLE_ADMIN"
//		 }
//		  ]
//		}
	  
	  
//	  Change to cid
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @PostMapping("/getcustomers")
	  public ResponseEntity<List<Customer>> getAllCustomerHandler() throws Exception{
		        
		  List<Customer> al=cService.getAllCustomer();
	
			   return new ResponseEntity<>( al , HttpStatus.ACCEPTED);
	
	  }
	  
	  
//	  update by Customer body
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @PutMapping("/updatecustomer/{id}")
	  public ResponseEntity<Customer> GetCustomerById(@PathVariable Integer id) throws Exception{

//		  cus.setPassword(passwordEncoder.encode(cus.getPassword()));
		  Customer customer= cuds.findById(id).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		  
//		   Customer cust =     cService.addCustomer(cus);
	         
		   return new ResponseEntity<>( customer, HttpStatus.ACCEPTED);

		
		  
	  }
	  
	  @GetMapping("/getLoggedInCustomerDetails")
		public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
			
			System.out.println(auth);
			
			 Customer customer= cuds.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
			
			 //to get the token in body, pass HttpServletResponse inside this method parameter 
			// System.out.println(response.getHeaders(SecurityConstants.JWT_HEADER));
			 
			 
			 return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
			
			
		}
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @DeleteMapping("/deletecustomerbyid/{id}")
      public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable Integer id) throws Exception{
    	        
    	  
    	    
    	
    		       
    		  return new ResponseEntity<Customer>(cService.deleteCustomerById(id), HttpStatus.CREATED);
    		  
    	
      } 
	  
}
