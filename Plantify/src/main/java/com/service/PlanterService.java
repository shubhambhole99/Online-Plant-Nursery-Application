package com.service;

import java.util.List;

import com.exception.PlanterException;
import com.model.Planter;

public interface PlanterService {
	
public Planter addPlanter(Planter planter)throws PlanterException;
	
	public Planter updatePlanter(Planter planter)throws PlanterException;
	
	public Planter updatePlanterHeightAndCapacity(Planter planter)throws PlanterException;
	
	public Planter updatePlanterDrainageHolesAndColor(Planter planter)throws PlanterException;
	
	public Planter updatePlanterStockAndCost(Planter planter)throws PlanterException;
	
	public String removePlanterByPlanterId(Integer planterId)throws PlanterException;
	
	public Planter viewPlanterByPlanterId(Integer planterId)throws PlanterException;
	
	public List<Planter> viewAllPlanterByPlanterShape(String planterShape)throws PlanterException;
	
	public List<Planter> viewAllPlanters()throws PlanterException;
	
	public List<Planter> viewAllPlantersBetweenTwoCostRange(Integer minCost, Integer maxCost)throws PlanterException;
	
	public List<Planter> viewAllPlanterByPlanterDrainageHoles(Integer numberOfDrainageHoles)throws PlanterException;

}
