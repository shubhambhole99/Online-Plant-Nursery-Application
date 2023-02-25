package com.security.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.dao.UserSessionDao;
import com.security.model.UserSession;
import com.security.model.UserType;

@Service
public class AuthenticationImpl  implements Authentication{
    
	
	@Autowired
	private UserSessionDao uDao;
	
	
	
	

	
	

	// login and creation of Admin or user;
	// call this just after creation or login or user
	@Override
	public String registerSession(Integer userId, UserType userType) throws Exception {
		// TODO Auto-generated method stub
		// generate a string
	     String randomString =	this.randomGeneratedString();
		
		UserSession user = new UserSession();
		user.setUser(userType);
		user.setUserId(userId);

		user.setSessionKey(randomString);
	
	    UserSession saveUser =	uDao.save(user);
		
		return saveUser.getSessionKey();
	}


	// Destroy session of Admin and user
    // call this just after logout 
	@Override
	public boolean destroySession(String key) throws Exception {
		// TODO Auto-generated method stub
		 Optional<UserSession>  opt = uDao.findBySessionKey(key);
			
		    if(opt.isPresent()) {
		    	   UserSession uSession = opt.get();
		    	   
		    	   uDao.delete(uSession);
		    	   
		    	   return true;
		    }else {
		    	 throw new Exception("Session is already removed");
		    }
	}
	
	
	
	
	
	
	
	public String randomGeneratedString() {
		
		   return  UUID.randomUUID().toString();
	}


	@Override
	public UserSession authenticate(String key) throws Exception {
		// TODO Auto-generated method stub
		 Optional<UserSession> opt =	uDao.findBySessionKey(key);
		  
		  
			if(opt.isPresent()) {
				return   opt.get();
			}else {
				 throw new Exception("User is not varified");
			}
	}


	

}
