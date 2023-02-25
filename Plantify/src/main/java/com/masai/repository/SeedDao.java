package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import com.exception.SeedException;
import com.masai.model.Seed;


@RestController
public interface SeedDao  extends JpaRepository<Seed, Integer>{
      
	@Query("from Seed")
	public List<Seed> getAllSeed();
}
