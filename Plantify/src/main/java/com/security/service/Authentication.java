package com.security.service;

import com.security.model.UserSession;
import com.security.model.UserType;

public interface Authentication {
            
	   public  String registerSession(Integer userId, UserType userType) throws Exception;	
	   
	   
	   
	   public boolean destroySession(String key) throws Exception;
	   
	    
	   public UserSession authenticate(String key) throws Exception;
	   
}
