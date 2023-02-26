package com.masai.service;

import java.util.List;

import com.exception.CustomerException;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.model.TempCustomer;

public interface CartService {


	Cart AddPlantToCart(Integer customer_id, Integer plantId);

	Cart AddPlanterToCart(Integer customer_id, Integer planterId);
}
