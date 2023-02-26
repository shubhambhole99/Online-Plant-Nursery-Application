package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.AdminException;
import com.masai.dto.SeedDTO;
import com.masai.model.Seed;
import com.masai.service.CustomerService;
import com.masai.service.SeedService;
import com.security.model.UserSession;
import com.security.model.UserType;
import com.security.service.Authentication;

@RestController
public class SeedController {
	@Autowired
	   private Authentication auth;
	   
	   
	   @Autowired
	   private CustomerService cService;
	   
	   
	   @Autowired
	   private SeedService seedService;
	
	
	@PostMapping("/addseed")
    public ResponseEntity<Seed> addSeedHandler(@RequestBody SeedDTO seedDto) throws Exception{
  	   
  	  // authorization check
  	  UserSession uSession =  auth.authenticate(seedDto.getKey());
  	  
  	  if(uSession.getUser().equals(UserType.ADMIN)) {
  		       
  		  return new ResponseEntity<Seed>(seedService.addSeed(seedDto.getSeed()), HttpStatus.CREATED);
  		  
  	  }else {
  		   throw new AdminException("You are not authorized to add seed Items");
  	  }
  	  
   }
	 @PostMapping("/updateseed")
     public ResponseEntity<Seed> updateSeedHandler(@RequestBody SeedDTO seedDto) throws Exception{
   	     
   	  // authorization check
   	  UserSession uSession =  auth.authenticate(seedDto.getKey());
   	  
   	  if(uSession.getUser().equals(UserType.ADMIN)) {
   		       
   		  return new ResponseEntity<Seed>(seedService.updateSeed(seedDto.getSeed()), HttpStatus.CREATED);
   		  
   	  }else {
   		   throw new AdminException("You are not authorized to update seed Items");
   	  }
   	  
     }
	 
	 @PostMapping("/deleteseed/{id}")
     public  ResponseEntity<Seed> deleteHandler(@PathVariable("id") Integer id, @RequestBody String key) throws Exception{
   	     
   	  // authorization check
   	  UserSession uSession =  auth.authenticate(key);
   	  
   	  if(uSession.getUser().equals(UserType.ADMIN)) {
   		       
   		  return new ResponseEntity<Seed>(seedService.removeSeed(id), HttpStatus.CREATED);
   		  
   	  }else {
   		   throw new AdminException("You are not authorized to delete seed Items");
   	  } 
     }
	 
	  @GetMapping("/seeds")
      public ResponseEntity<List<Seed>> getAllSeedHandler(){
    	  
    	  return new ResponseEntity<List<Seed>>(seedService.getAllSeed(), HttpStatus.ACCEPTED);
      }
      
	 
	 
}
