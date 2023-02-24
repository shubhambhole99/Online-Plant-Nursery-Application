package com.masai.service;

import org.springframework.data.jpa.repository.Query;

import com.exception.AdminException;
import com.masai.model.Admin;

public interface AdminService {
	
	     
	
	public Admin getAdminByNameAndId(String username, Integer id) throws AdminException;
      
      
      
}
