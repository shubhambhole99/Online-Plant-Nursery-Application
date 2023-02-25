package com.masai.service;

import org.springframework.stereotype.Service;

import com.exception.AdminException;
import com.masai.model.Admin;
import com.masai.repository.AdminDao;

@Service
public class AdminServiceImp  implements AdminService{
	
	
	private AdminDao aDao;

	@Override
	public Admin getAdminByNameAndPassword(String username, String password) throws AdminException {
		// TODO Auto-generated method stub
		
	     return	aDao.findByUsernameAndPassword(username, password);
		
	}

	
        
}
