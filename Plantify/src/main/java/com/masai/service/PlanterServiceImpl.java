package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.PlanterException;
import com.masai.model.Planter;
import com.masai.repository.PlanterDao;

@Service
public class PlanterServiceImpl implements PlanterService{
	
	@Autowired
	private PlanterDao planterDao;

	@Override
	public Planter addPlanter(Planter planter)
			throws PlanterException {
		// TODO Auto-generated method stub
		return planterDao.save(planter);
	}

	@Override
	public Planter updatePlanter(Planter planter) throws PlanterException {
		// TODO Auto-generated method stub
Optional<Planter> pltr = planterDao.findById(planter.getPlanterId());
		
		if(pltr.isPresent()) {
			Planter p = pltr.get();
			p.setDrainageHoles(planter.getDrainageHoles());
			p.setPlanterCapacity(planter.getPlanterCapacity());
			p.setPlanterColor(planter.getPlanterColor());
			p.setPlanterCost(planter.getPlanterCost());
			p.setPlanterHeight(planter.getPlanterHeight());
			p.setPlanterShape(planter.getPlanterShape());
			p.setPlanterStock(planter.getPlanterStock());
		
			return planterDao.save(p);
			
		}else {
			throw new PlanterException("Planter not found provide valid data");
		}
	}

	@Override
	public Planter updatePlanterHeightAndCapacity(Planter planter) throws PlanterException {
Optional<Planter> pltr = planterDao.findById(planter.getPlanterId());
		
		if(pltr.isPresent()) {
			
			Planter p = pltr.get();
			p.setPlanterHeight(planter.getPlanterHeight());
			p.setPlanterCapacity(planter.getPlanterCapacity());
			
			return planterDao.save(p);
			
		}else {
			throw new PlanterException("Planter not found provide valid data");
		}
	}

	@Override
	public Planter updatePlanterDrainageHolesAndColor(Planter planter) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Planter updatePlanterStockAndCost(Planter planter) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removePlanterByPlanterId(Integer planterId) throws PlanterException {
		// TODO Auto-generated method stub
		Planter p = planterDao.findById(planterId).orElseThrow(()-> new PlanterException("Planter not found"));
		planterDao.delete(p);
		return "deleted";
	}

	@Override
	public Planter viewPlanterByPlanterId(Integer planterId) throws PlanterException {
		// TODO Auto-generated method stub
Optional<Planter> planter = planterDao.findById(planterId);
		
		if(planter.isPresent()) {
			return planter.get();
		}else {
			throw new PlanterException("planter does not exist for this planter id: "+planterId);
		}
	}


	@Override
	public List<Planter> viewAllPlanterByPlanterShape(String planterShape) throws PlanterException {
List<Planter> planters = planterDao.findByPlanterShape(planterShape);
		
		if(planters.isEmpty()) {
			throw new PlanterException("Not found any Planter for this planter shape: "+planterShape);
		}
		
		return planters;
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {
		List<Planter> planters = planterDao.findAll();
		if(planters.isEmpty()) {
			throw new PlanterException("Empty planter list..");
		}
		return planters;
	}

	@Override
	public List<Planter> viewAllPlantersBetweenTwoCostRange(Integer minCost, Integer maxCost) throws PlanterException {
List<Planter> planters = planterDao.findByPlanterBetween(minCost, maxCost);
		
		if(planters.isEmpty()) {
			throw new PlanterException("Planters not fount cost between: "+minCost+" and "+maxCost);
		}
		
		return planters;
		
	}
	

	@Override
	public List<Planter> viewAllPlanterByPlanterDrainageHoles(Integer numberOfDrainageHoles) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}



}
