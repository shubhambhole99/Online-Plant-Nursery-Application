package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exception.PlanterException;
import com.masai.model.Planter;

@Repository
public interface PlanterDao extends JpaRepository<Planter, Integer>{
	
public List<Planter> findByPlanterShape(String planterShape) throws PlanterException;

	
	
	@Query("Select p from Planter p where p.planterCost>=?1 and p.planterCost<=?2")
	public List<Planter> findByPlanterBetween(Integer minCost, Integer maxCost) throws PlanterException;
	
	public List<Planter> findByDrainageHoles(Integer numberOfDrainageHoles) throws PlanterException;

}
