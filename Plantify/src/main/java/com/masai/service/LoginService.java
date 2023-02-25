package com.masai.service;

import com.exception.LoginException;
import com.masai.dto.UserDTO;

public interface LoginService {
      
	
	public String login(UserDTO userDto)throws LoginException, Exception;
	
	
	public String logout(String key) throws Exception;
}
