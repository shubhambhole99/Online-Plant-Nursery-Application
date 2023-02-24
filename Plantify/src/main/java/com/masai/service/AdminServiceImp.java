package com.masai.service;

import org.springframework.stereotype.Service;

import com.exception.AdminException;
import com.masai.model.Admin;
import com.masai.repository.AdminDao;

@Service
public class AdminServiceImp  implements AdminService{
	
	
	private AdminDao aDao;

	@Override
	public Admin getAdminByNameAndId(String username, Integer id) throws AdminException {
		// TODO Auto-generated method stub
		
	     return	aDao.findByUsernameAndId(username, id);
		
	}

	
        
}
