package com.masai.service;

import java.util.List;

import com.exception.CustomerException;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.model.TempCustomer;

public interface CustomerService {

	public String addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;

	
	public Customer getCustomerById(Customer customer) throws CustomerException;

	
	public Customer deleteCustomerById(Integer id) throws CustomerException;

	
	public List<Customer> getAllCustomer() throws CustomerException;

	
	public Customer getCustomerByUserNameAnsPassword(String username, String password) throws CustomerException;
}
