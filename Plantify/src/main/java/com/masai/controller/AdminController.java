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

import com.masai.model.Plant;
import com.masai.service.PlantService;

import jakarta.validation.Valid;

@RestController
public class AdminController {

@Autowired
private PlantService ps;



@GetMapping("/p")
public String tryid() {
	return "s";
}
@PostMapping("/plants")
public ResponseEntity<Plant> SavePlantsHandler(@Valid @RequestBody Plant plant){
	Plant sp=ps.AddPlant(plant);
	return new ResponseEntity<Plant>(sp,HttpStatus.CREATED);
}

@PostMapping("/updateplant/{pid}")
public ResponseEntity<Plant> UpdatePlantsHandler(@Valid @RequestBody Plant plant,@PathVariable("pid")Integer pid){
	Plant sp=ps.UpdatePlant(plant, pid);
	return new ResponseEntity<Plant>(sp,HttpStatus.CREATED);
}

@PostMapping("/deleteplants/{pid}")
public ResponseEntity<Plant> DeletePlantsHandler(@PathVariable("pid")Integer pid){
	Plant sp=ps.DeletePlant(pid);
	return new ResponseEntity<Plant>(sp,HttpStatus.CREATED);
}

@GetMapping("/getallplants")
public ResponseEntity<List<Plant>> GetAllHandler(){
	List<Plant> sp=ps.GetAllPlants();
	return new ResponseEntity<>(sp,HttpStatus.CREATED);
}





}
