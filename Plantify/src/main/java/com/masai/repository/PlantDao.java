package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.model.Plant;

@Repository
public interface PlantDao extends JpaRepository<Plant,Integer>{
	
	
	public List<Plant> findByplanttype(String planttype);

}
