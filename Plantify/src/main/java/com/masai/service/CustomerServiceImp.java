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

	   Customer savedC =	     cDao.findById(customer.getCustomerId()).orElseThrow(() -> new CustomerException("There is not customer for update with thid id "+customer.getCustomerId()));

        if(customer.getMobileNo() != null) {
        	  savedC.setMobileNo(customer.getMobileNo());
        }
        
        if(customer.getUsername() != null) {
      	  savedC.setUsername(customer.getUsername());
       }  
        
        if(customer.getAddress() != null) {
      	  savedC.setAddress(customer.getAddress());
       }   
        
        if(customer.getPassword() != null) {
      	  savedC.setPassword(customer.getPassword());
      }
        
       Customer saved = cDao.save(savedC);
       
       return saved;
	}

	@Override
	public Customer getCustomerById(Integer cId) throws CustomerException {
		// TODO Auto-generated method stub
		  
	   return    cDao.findById(cId).orElseThrow(() -> new CustomerException("There is no customer with this id "+cId));
		
	

		
	}

	
	

	@Override
	public Customer deleteCustomerById(Integer id) throws CustomerException {
		// TODO Auto-generated method stub

		
	    Customer c = 	cDao.findById(id).orElseThrow(() -> new CustomerException("There is no customer with this id "+id));
		
	      cDao.delete(c);
	      
	      return c;
	}
	
	@Override
	public List<Customer> getAllCustomer() throws CustomerException {
		// TODO Auto-generated method stub

	  List<Customer> list =	 cDao.findAll();
	  
	  if(list.size() != 0) {
		     return list;
	  }else 
		  throw new CustomerException("Oops! There is not customer is registered yet");

	}

	@Override
	public Customer getCustomerByUserNameAnsPassword(String username, String password) throws CustomerException {
		// TODO Auto-generated method stub
	   return 	 cDao.getByUsernameAndByPassword(username, password);
		
		
	}

	

}
