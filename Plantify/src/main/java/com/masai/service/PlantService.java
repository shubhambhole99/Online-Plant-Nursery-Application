package com.masai.service;

import java.util.List;

import com.masai.model.Plant;

public interface PlantService {

	public Plant AddPlant(Plant plant);
	public Plant UpdatePlant(Plant plant,Integer plantid);
	public Plant DeletePlant(Integer plantid);
	public List<Plant> GetAllPlants();
	public Plant GetPlantById(Integer plantid);
	public Plant FindPlantByType(String planttype);
}
