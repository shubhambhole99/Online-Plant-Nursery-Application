package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.PlanterException;
import com.model.Planter;
import com.repository.PlanterDao;

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
		return null;
	}

	@Override
	public Planter updatePlanterHeightAndCapacity(Planter planter) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

	@Override
	public List<Planter> viewAllPlanterByPlanterShape(String planterShape) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewAllPlanters() throws PlanterException {
		// TODO Auto-generated method stub
		return planterDao.getAllExcept();
	}

	@Override
	public List<Planter> viewAllPlantersBetweenTwoCostRange(Integer minCost, Integer maxCost) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> viewAllPlanterByPlanterDrainageHoles(Integer numberOfDrainageHoles) throws PlanterException {
		// TODO Auto-generated method stub
		return null;
	}

}
