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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.AdminException;
import com.masai.model.Plant;
import com.masai.model.Seed;
import com.masai.service.PlantService;
import com.masai.service.SeedService;

import jakarta.validation.Valid;

@RestController
@EnableMethodSecurity
@RequestMapping("/plant")
public class PlantController {

	@Autowired
	private PlantService ps;


@PreAuthorize("hasRole('ROLE_ADMIN')")
@PostMapping("/Saveplant")
public ResponseEntity<Plant> SavePlantsHandler(@Valid @RequestBody Plant plant) throws Exception{
    
	Plant sp=ps.AddPlant(plant);
   	        return new ResponseEntity<Plant>(sp,HttpStatus.CREATED);
        }
	
   
@PreAuthorize("hasRole('ROLE_ADMIN')")
@PostMapping("/UpdateplantbyId/{pid}")
public ResponseEntity<Plant> UpdatePlantsHandler(@Valid @RequestBody Plant plant,@PathVariable("pid")Integer pid) throws Exception{
	Plant sp=ps.UpdatePlant(plant, pid);
	return new ResponseEntity<Plant>(sp,HttpStatus.CREATED);
}
	

@PreAuthorize("hasRole('ROLE_ADMIN')")
@PostMapping("/DeleteplantbyId/{pid}")
public ResponseEntity<Plant> DeletePlantsHandler(@PathVariable("pid")Integer pid) throws Exception{
	
	Plant sp=ps.DeletePlant(pid);
	return new ResponseEntity<Plant>(sp,HttpStatus.CREATED);
}
	
@PreAuthorize("hasRole('ROLE_ADMIN','ROLE_USER')")
@GetMapping("/Getallplants")
public ResponseEntity<List<Plant>> GetAllHandler(){
	List<Plant> sp=ps.GetAllPlants();
	return new ResponseEntity<>(sp,HttpStatus.CREATED);
}

@PreAuthorize("hasRole('ROLE_ADMIN','ROLE_USER')")
@GetMapping("/Getplantbyid/{pid}")
public ResponseEntity<Plant> GetPlantByIdHandler(@PathVariable("pid")Integer pid){
	Plant sp=ps.GetPlantById(pid);
	return new ResponseEntity<>(sp,HttpStatus.CREATED);
}

@PreAuthorize("hasRole('ROLE_ADMIN','ROLE_USER')")
@GetMapping("/Getplantbytype/{pt}")
public ResponseEntity<List<Plant>> GetPlantByIdHandler(@PathVariable("pt")String pt){
	List<Plant> sp=ps.FindPlantByType(pt);
	return new ResponseEntity<>(sp,HttpStatus.CREATED);
}
}
