package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.AdminException;
import com.masai.dto.SeedDTO;
import com.masai.model.Admin;
import com.masai.model.Plant;
import com.masai.model.Seed;
import com.masai.service.AdminService;
import com.masai.service.PlantService;
import com.masai.service.SeedService;
import com.security.model.UserSession;
import com.security.model.UserType;
import com.security.service.Authentication;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/plant")
public class PlantController {

@Autowired
private PlantService ps;


   @Autowired 
   private AdminService aService;
   
   
   @Autowired
   private Authentication auth;
   
   
@PostMapping("/Saveplant/{key}")
public ResponseEntity<Plant> SavePlantsHandler(@Valid @RequestBody Plant plant,@PathVariable("key")String key) throws Exception{
	UserSession uSession =  auth.authenticate(key);
	if(uSession.getUser().equals(UserType.ADMIN)) {         
	Plant sp=ps.AddPlant(plant);
   	        return new ResponseEntity<Plant>(sp,HttpStatus.CREATED);
        }
	else {
		throw new AdminException("You are not authorized to add seed Items");

	}
}
   

@PostMapping("/UpdateplantbyId/{pid}/{key}")
public ResponseEntity<Plant> UpdatePlantsHandler(@Valid @RequestBody Plant plant,@PathVariable("pid")Integer pid,@PathVariable("key")String key) throws Exception{
	Plant sp=ps.UpdatePlant(plant, pid);
	UserSession uSession =  auth.authenticate(key);
	if(uSession.getUser().equals(UserType.ADMIN)) {   
	return new ResponseEntity<Plant>(sp,HttpStatus.CREATED);
}
	else {
		throw new AdminException("You are not authorized to add seed Items");

	}
}

@PostMapping("/DeleteplantbyId/{pid}/{key}")
public ResponseEntity<Plant> DeletePlantsHandler(@PathVariable("pid")Integer pid,@PathVariable("key")String key) throws Exception{
	
	UserSession uSession =  auth.authenticate(key);
	if(uSession.getUser().equals(UserType.ADMIN)) { 
	Plant sp=ps.DeletePlant(pid);
	return new ResponseEntity<Plant>(sp,HttpStatus.CREATED);
}
	else {
		throw new AdminException("You are not authorized to add seed Items");

	}
}

@GetMapping("/Getallplants")
public ResponseEntity<List<Plant>> GetAllHandler(){
	List<Plant> sp=ps.GetAllPlants();
	return new ResponseEntity<>(sp,HttpStatus.CREATED);
}
@GetMapping("/Getplantbyid/{pid}")
public ResponseEntity<Plant> GetPlantByIdHandler(@PathVariable("pid")Integer pid){
	Plant sp=ps.GetPlantById(pid);
	return new ResponseEntity<>(sp,HttpStatus.CREATED);
}
@GetMapping("/Getplantbytype/{pt}")
public ResponseEntity<List<Plant>> GetPlantByIdHandler(@PathVariable("pt")String pt){
	List<Plant> sp=ps.FindPlantByType(pt);
	return new ResponseEntity<>(sp,HttpStatus.CREATED);
}



       



     
      

}
