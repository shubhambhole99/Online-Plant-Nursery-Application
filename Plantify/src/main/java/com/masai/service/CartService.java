package com.masai.service;

import java.util.List;

import com.exception.CustomerException;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Orders;


public interface CartService {


	Cart AddPlantToCart(Integer customer_id, Integer plantId);

	Cart AddPlanterToCart(Integer customer_id, Integer planterId);

	Cart AddSeedToCart(Integer customer_id,Integer seedId);
	
	Cart RemovePlantFromCart(Integer customer_id, Integer plantId);

	Cart RemovePlanterFromCart(Integer customer_id, Integer plantId);

	Cart RemoveSeedFromCart(Integer customer_id, Integer seedId);

	Orders CheckoutCart(Integer customer_id);
	
//	void setpriceanditems(Integer customer_id);
}
