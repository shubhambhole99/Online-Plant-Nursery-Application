package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exception.AdminException;
import com.masai.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
              
	
	 @Query("from Admin a where a.name=:username and a.id = :password")
     public Admin findByUsernameAndPassword(String username, String password);
}
