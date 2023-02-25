package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.Plant;
import com.masai.service.AdminService;
import com.masai.service.PlantService;

import jakarta.validation.Valid;

@RestController
public class AdminController {

@Autowired
private PlantService ps;


   @Autowired 
   private AdminService aService;



          @GetMapping("/p")
          public String tryid() {
	          return "s";
          }
       
       
          @PostMapping("/plants")
          public ResponseEntity<Plant> SavePlantsHandler(@Valid @RequestBody Plant plant){
	                  Plant sp=ps.AddPlant(plant);
	                 return new ResponseEntity<Plant>(sp,HttpStatus.CREATED);
              }



      @PostMapping("/register")
      public ResponseEntity<String> createAdmin(Admin admin) throws AdminException {
    	  
    	           
    	  
    	String key =    aService.createAdmin(admin);
    	
    	
    	return new ResponseEntity<>(key, HttpStatus.CREATED);
    	    
    	  
    	  
      }

}
