package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.AdminException;
import com.model.Planter;
import com.security.model.UserSession;
import com.security.model.UserType;
import com.security.service.Authentication;
import com.service.PlanterService;

@RestController
public class PlanterController {
	
	@Autowired(required = true)
	private PlanterService planterService;
	
	@Autowired
	   private Authentication auth;
	//================================================Planter addition=========================================================
	
	
	
	@PostMapping("/planters/{key}")
	public ResponseEntity<Planter> addPlanterHandler(@RequestBody Planter planter,@PathVariable("key")String key) throws Exception{
		UserSession uSession =  auth.authenticate(key);
		if(uSession.getUser().equals(UserType.ADMIN)) {
		Planter planter1 = planterService.addPlanter(planter);
		return new ResponseEntity<Planter>(planter1, HttpStatus.CREATED);
		}
		else {
			throw new AdminException("You are not authorized to add seed Items");
		}
	}
	
	
	//=======================================================Update Planter==========================================================

	
	@PutMapping("/planters/{key}")
	public ResponseEntity<Planter> updatePlanterHandler(@RequestBody Planter planter,@PathVariable("key")String key) throws Exception{
		
		UserSession uSession =  auth.authenticate(key);
		if(uSession.getUser().equals(UserType.ADMIN)) {
		Planter planter1 = planterService.updatePlanter(planter);
		
		return new ResponseEntity<Planter>(planter1, HttpStatus.CREATED);
		
	}
		else {
		throw new AdminException("You are not authorized to add seed Items");
	}
	
	}
	
	//=================================Update Planter Height and Capacity========================================================
	
	
	
	@PutMapping("/planters/heightAndCapacity/{key}")
	public ResponseEntity<Planter> updatePlanterHeightAndCapacityHandler(@RequestBody Planter planter,@PathVariable("key")String key) throws Exception{
		
		UserSession uSession =  auth.authenticate(key);
		if(uSession.getUser().equals(UserType.ADMIN)) {
		Planter planter1 = planterService.updatePlanterHeightAndCapacity(planter);
		
		return new ResponseEntity<Planter>(planter1, HttpStatus.CREATED);
		
	}
		else {
			throw new AdminException("You are not authorized to add seed Items");

		}
	
	
	}
	//==============================================Update planter DrainageHoles And Color=========================================
	
	
	
//	@PutMapping("/planters/drainageHolesAndColor")
//	public ResponseEntity<Planter> updatePlanterDrainageHolesAndColorHandler(@RequestBody Planter planter){
//		
//		Planter planter1 = planterService.updatePlanterDrainageHolesAndColor(planter);
//		
//		return new ResponseEntity<Planter>(planter1, HttpStatus.CREATED);
//		
//	}
//	
//	
//	//=============================================Update Planter Stock and Cost====================================================
//	
//	
//	
//	@PutMapping("/planters/StockAndCost")
//	public ResponseEntity<Planter> updatePlanterStockAndCostHandler(@RequestBody Planter planter){
//	
//		Planter planter1 = planterService.updatePlanterStockAndCost(planter);
//		
//		return new ResponseEntity<Planter>(planter1, HttpStatus.CREATED);
//		
//	}
	
	
	//================================================Delete Planter By planter Id=================================================
	
	
	
	@DeleteMapping("/planters/{planterId}/{key}")
	public ResponseEntity<String> removePlanterByPlanterIdHandler(@PathVariable("planterId") Integer planterId,@PathVariable("key")String key) throws Exception{
		
		UserSession uSession =  auth.authenticate(key);
		if(uSession.getUser().equals(UserType.ADMIN)) {
		String message = planterService.removePlanterByPlanterId(planterId);
		
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
		
	}
		else {
			throw new AdminException("You are not authorized to add seed Items");

		}
	}
	
	
	//===================================================View Planter By planter id==================================================

	
	
	@GetMapping("/planterview/{planterId}")
	public ResponseEntity<Planter> viewPlanterByPlanterIdHandler(@PathVariable("planterId") Integer planterId) throws Exception{
		
		Planter planter = planterService.viewPlanterByPlanterId(planterId);
		
		return new ResponseEntity<>(planter, HttpStatus.OK);
		
	}
	
	
	
	
	//==========================================================View All Planters By Planter Shape================================
	
	
	
	
	@GetMapping("/planters/{planterShape}")
	public ResponseEntity<List<Planter>> viewAllPlanterByPlanterShapeHandler(@PathVariable("planterShape") String planterShape){
		
		List<Planter> planters = planterService.viewAllPlanterByPlanterShape(planterShape);
		
		return new ResponseEntity<>(planters, HttpStatus.OK);
		
	}
	
	
	//========================================================View All Planters====================================================
	
	
	
	@GetMapping("/planters")
	public ResponseEntity<List<Planter>> viewAllPlantersHandler(){
		
		
		List<Planter> planters = planterService.viewAllPlanters();
		
		return new ResponseEntity<>(planters, HttpStatus.OK);
		
	}
	
	
	//====================================View All Planters cost Between===========================================================

	
	
	@GetMapping("/plantersByCost/{minCost}/{maxCost}")
	public ResponseEntity<List<Planter>> viewAllPlantersBetweenTwoCostRangeHandler(@PathVariable("minCost") Integer minCost, @PathVariable("maxCost") Integer maxCost){
		
		List<Planter> planters = planterService.viewAllPlantersBetweenTwoCostRange(minCost, maxCost);
		
		return new ResponseEntity<>(planters, HttpStatus.OK);
		
	}
	

}
