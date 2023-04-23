package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.CustomerException;
import com.exception.UserSessionException;
import com.masai.model.Authority;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.repository.CartRepo;
import com.masai.repository.CustomerDao;



@Service
public class CustomerServiceImp implements CustomerService {
	
	
	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	CartRepo cr;


	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		String email=customer.getEmail();
		try {
		 Customer custo=cDao.findByEmail(email).get();
		 if(custo!=null) {
			 throw new CustomerException("User Exists");
		 }
		}catch(NoSuchElementException e1) {
		
		
		
		
		Cart cart=new Cart();
		 cart.setPlanterlist(new ArrayList<>());
		 cart.setPlantlist(new ArrayList<>());
		 cart.setSeedlist(new ArrayList<>());
		 cart.setTotalitems(0);
		 cart.setTotalprice(0);
		 
		
		 
		 List<Authority> authorities= customer.getAuthorities();
			
			for(Authority authority:authorities) {
				authority.setCustomer(customer);
			}
		 
		 cr.save(cart);
		 customer.setOd(cart);
		Customer saved = cDao.save(customer);
		

	
		   return 	saved;
		   
		
		
		
	}
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub

	List<Authority> authorities= customer.getAuthorities();
		
		for(Authority authority:authorities) {
			authority.setCustomer(customer);
		}
		
		return cDao.save(customer);
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
		  throw new CustomerException("No Customers");

	}

	@Override
	public Customer getCustomerByUserNameAnsPassword(String username, String password) throws CustomerException {
		// TODO Auto-generated method stub
	   return 	 cDao.getByUsernameAndByPassword(username, password);
		
		
	}

	

}
