package com.masai.service;

import com.masai.model.Cart;
import com.masai.model.Plant;
import com.masai.model.TempCustomer;

public interface CustomerService {

	public Cart AddPlantToCart(Integer customer_id,Integer plantId);
	
	public Cart RemovePlantFromCart(Integer customer_id,Integer plantId);
	
	public TempCustomer AddCustomer(TempCustomer cust);
}
