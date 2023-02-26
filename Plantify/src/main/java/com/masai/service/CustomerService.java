package com.masai.service;

import com.masai.model.Cart;
import com.masai.model.Plant;
import com.masai.model.TempCustomer;

public interface CustomerService {

	
	


	public Customer getCustomerById(Integer cId) throws CustomerException;
	
	
	
	public Customer deleteCustomerById(Integer id) throws CustomerException;
	
	public List<Customer> getAllCustomer() throws CustomerException;

	
	
}
