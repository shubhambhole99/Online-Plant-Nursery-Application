package com.masai.service;

import org.springframework.data.jpa.repository.Query;

import com.exception.AdminException;
import com.masai.model.Admin;

public interface AdminService {
	
	     
	
	public Admin getAdminByNameAndPassword(String username, String password) throws AdminException;

	
	
	
	public String createAdmin(Admin admin) throws AdminException;
	
	
	public Admin getAdminByIdService(Integer adminId) throws AdminException;
	
	

      
      
      
}
