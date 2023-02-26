package com.masai.service;

import java.util.List;

import com.exception.SeedException;
import com.masai.model.Seed;

public interface SeedService {
	
	 public Seed addSeed(Seed seed) throws SeedException;
	 
	 public Seed updateSeed(Seed seed) throws SeedException;

	 public List<Seed> getAllSeed() throws SeedException;
	 
	 
	 public Seed removeSeed(Integer seedId) throws SeedException;
	 
}
