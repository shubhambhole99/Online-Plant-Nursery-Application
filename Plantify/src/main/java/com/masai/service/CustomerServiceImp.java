package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.CustomerException;
import com.exception.UserSessionException;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;
import com.security.model.UserType;
import com.security.service.Authentication;


@Service
public class CustomerServiceImp implements CustomerService {
	
	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private Authentication auth;

	@Override
	public String addCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		 
		Customer saved = cDao.save(customer);
		
		auth.authenticate(null);
		try {
		   return 	auth.registerSession(saved.getCustomerId(), UserType.USER);
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 throw new UserSessionException("Session is not create for user");
		}
		
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomerById(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerByUserNameAnsPassword(String username, String password) throws CustomerException {
		// TODO Auto-generated method stub
	   return 	 cDao.getByUsernameAndByPassword(username, password);
		
		
	}

}
