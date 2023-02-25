package com.masai.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.AdminException;
import com.exception.UserSessionException;
import com.masai.model.Admin;
import com.masai.repository.AdminDao;
import com.security.model.UserType;
import com.security.service.Authentication;


@Service
public class AdminServiceImp  implements AdminService{
	

	@Autowired
	private AdminDao aDao;
	
	@Autowired
	private Authentication auth;

	


	@Override
	public Admin getAdminByNameAndPassword(String username, String password) throws AdminException {
		// TODO Auto-generated method stub
		
	     return	aDao.findByUsernameAndPassword(username, password);
		
	}

	@Override
	public String createAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		 Admin  saved =   aDao.save(admin);
		 

			try {
			   return 	auth.registerSession(saved.getId(), UserType.ADMIN);
			   
			} catch (Exception e) {
				// TODO Auto-generated catch block
				 throw new UserSessionException("Session is not create for user");
			}
		
	}

	
        
}
