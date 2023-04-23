package com.masai.service;

import java.util.List;

import com.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;


	public Customer getCustomerById(Integer cId) throws CustomerException;

	public Customer updateCustomer(Customer customer) throws CustomerException;

	
	

	
	
	
	public Customer deleteCustomerById(Integer id) throws CustomerException;
	
	public List<Customer> getAllCustomer() throws CustomerException;


	
	

	
	public Customer getCustomerByUserNameAnsPassword(String username, String password);

}
