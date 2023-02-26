package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.AdminException;
import com.masai.dto.KeyDTO;
import com.masai.dto.SeedDTO;
import com.masai.model.Admin;
import com.masai.model.Customer;
import com.masai.model.Plant;
import com.masai.model.Seed;
import com.masai.service.AdminService;
import com.masai.service.CustomerService;
import com.masai.service.PlantService;
import com.masai.service.SeedService;
import com.security.model.UserSession;
import com.security.model.UserType;
import com.security.service.Authentication;

import jakarta.validation.Valid;

@RestController
public class AdminController {

@Autowired
private PlantService ps;


   @Autowired 
   private AdminService aService;
   
   
   @Autowired
   private Authentication auth;
   
   
   @Autowired
   private CustomerService cService;
   
   
   @Autowired
   private SeedService seedService;


//   RegisterAdmin
      @PostMapping("/registeradmin")
      public ResponseEntity<String> createAdmin(Admin admin) throws AdminException {
    	  
    	           
    	  
    	String key =    aService.createAdmin(admin);
    	
    	
    	return new ResponseEntity<>(key, HttpStatus.CREATED);
    	    
    	  
    	  
      }
      
  
      
    
      
      // get a customer by id
      @PostMapping("/getcustomerbyid/{id}")
      public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable Integer id, @RequestBody KeyDTO keyDto) throws Exception{
    	        
    	  
    	    
    	  // authorization check
    	  UserSession uSession =  auth.authenticate(keyDto.getKey());
    	  
    	  if(uSession.getUser().equals(UserType.ADMIN)) {
    		       
    		  return new ResponseEntity<Customer>(cService.getCustomerById(id), HttpStatus.CREATED);
    		  
    	  }else {
    		   throw new AdminException("You are not authorized to get Customer");
    	  } 
      }
      
      
      // get list of customer
      @PostMapping("/getallcustomers")
      public ResponseEntity<List<Customer>> getAllCustomerHandler(@RequestBody KeyDTO keyDto) throws Exception{
    	        
    	  
    	    
    	  // authorization check
    	  UserSession uSession =  auth.authenticate(keyDto.getKey());
    	  
    	  if(uSession.getUser().equals(UserType.ADMIN)) {
    		       
    		  return new ResponseEntity<List<Customer>>(cService.getAllCustomer(), HttpStatus.CREATED);
    		  
    	  }else {
    		   throw new AdminException("You are not authorized to get Customer");
    	  } 
      }  
      
      
      // Delete a customer using his id
      @DeleteMapping("/deletecustomerbyid/{id}")
      public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable Integer id,@RequestBody KeyDTO keyDto) throws Exception{
    	        
    	  
    	    
    	  // authorization check
    	  UserSession uSession =  auth.authenticate(keyDto.getKey());
    	  
    	  if(uSession.getUser().equals(UserType.ADMIN)) {
    		       
    		  return new ResponseEntity<Customer>(cService.deleteCustomerById(id), HttpStatus.CREATED);
    		  
    	  }else {
    		   throw new AdminException("You are not authorized to get Customer");
    	  } 
      } 
    	       
      }
      
      
      
      


