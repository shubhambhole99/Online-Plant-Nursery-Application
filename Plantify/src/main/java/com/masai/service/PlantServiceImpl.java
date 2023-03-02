package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Plant;
import com.masai.repository.PlantDao;

@Service
public class PlantServiceImpl implements PlantService {

@Autowired
private PlantDao pd;

@Override
public Plant AddPlant(Plant plant) {
	// TODO Auto-generated method stub
	Plant savedplant=pd.save(plant);
	if(savedplant!=null) {
		return savedplant;
	}
	else {
		throw new IllegalAccessError("Plant Cannot Registered");
	}
	
}
@Override
public Plant UpdatePlant(Plant plant,Integer plantId) {
	// TODO Auto-generated method stub
	Plant findplant=pd.findById(plantId).get();
	if(findplant!=null){
		plant.setPlant_id(findplant.getPlant_id());  
		Plant sp1=pd.save(plant);
		return sp1;
	}
	else {
		throw new IllegalAccessError("Plant Cannot Registered");
	}	
}
@Override
public Plant DeletePlant(Integer plantid) {
	Plant findplant=pd.findById(plantid).get();
	if(findplant!=null){
		pd.deleteById(plantid);
		return findplant;
	}
	else {
		throw new IllegalAccessError("Plant Cannot Registered");
	}	
	
	// TODO Auto-generated method stub
}

@Override
public List<Plant> GetAllPlants() {
	// TODO Auto-generated method stub
	List<Plant> pl=pd.findAll();
	if(pl!=null) {
		return pl;
	}
	else {
		throw new IllegalAccessError("Plant Cannot Registered");
	}	
	
}

@Override
public Plant GetPlantById(Integer plantid) {
	Plant findplant=pd.findById(plantid).get();
	if(findplant!=null){
		
		return findplant;
	}
	else {
		throw new IllegalAccessError("Plant Cannot Registered");
	}	
	
}
@Override
public List<Plant> FindPlantByType(String planttype) {
	// TODO Auto-generated method stub
	List<Plant> pl=pd.findByplanttype(planttype);
	if(pl!=null) {
		return pl;
	}
	else {
		throw new IllegalAccessError("Plant Cannot Registered");
	}
	
}


}
