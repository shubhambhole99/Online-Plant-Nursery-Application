package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.AdminException;
import com.masai.model.Seed;
import com.masai.service.CustomerService;
import com.masai.service.SeedService;

@RestController
@EnableMethodSecurity
public class SeedController {

	   
	   
	   @Autowired
	   private CustomerService cService;
	   
	   
	   @Autowired
	   private SeedService seedService;
	
	
   @PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addseed")
    public ResponseEntity<Seed> addSeedHandler(@RequestBody Seed seed) throws Exception{
  	   
 
  	
  		       
  		  return new ResponseEntity<Seed>(seedService.addSeed(seed), HttpStatus.CREATED);
  		 
  	  
   }
   
   	@PreAuthorize("hasRole('ROLE_ADMIN')")
	 @PostMapping("/updateseed")
     public ResponseEntity<Seed> updateSeedHandler(@RequestBody Seed seed) throws Exception{
   	     

   		       
   		  return new ResponseEntity<Seed>(seedService.updateSeed(seed), HttpStatus.CREATED);
   		  
   	 
   	  
     }
	 
   	@PreAuthorize("hasRole('ROLE_ADMIN')")
	 @PostMapping("/deleteseed/{id}")
     public  ResponseEntity<Seed> deleteHandler(@PathVariable("id") Integer id) throws Exception{
   	     
   	  // authorization check
   
   		       
   		  return new ResponseEntity<Seed>(seedService.removeSeed(id), HttpStatus.CREATED);
   		  
   	
     }
	 
   	@PreAuthorize("hasRole('ROLE_ADMIN','ROLE_USER')")
	  @GetMapping("/seeds")
      public ResponseEntity<List<Seed>> getAllSeedHandler(){
    	  
    	  return new ResponseEntity<List<Seed>>(seedService.getAllSeed(), HttpStatus.ACCEPTED);
      }
      
	 
	 
}
