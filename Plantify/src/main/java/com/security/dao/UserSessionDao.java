package com.security.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.model.UserSession;


@Repository
public interface UserSessionDao extends JpaRepository<UserSession, Integer>{
        
	     
	  public Optional<UserSession> findBySessionKey(String key);
	
}
