package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Cart;
import com.masai.model.Orders;
import com.masai.model.Plant;
import com.masai.model.TempCustomer;
import com.masai.repository.CustomerDao;
import com.masai.repository.OrderDao;
import com.masai.repository.PlantDao;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CustomerDao cd;
	@Autowired
	PlantDao pd;
	
	@Autowired
	OrderDao ord;
	
	
	public TempCustomer AddCustomer(TempCustomer cust) {
		TempCustomer scus=cd.save(cust);
		
		return scus;
		
	}
	
	
	
	@Override
	public Cart AddPlantToCart(Integer customer_id,Integer plantId) {
		// TODO Auto-generated method stub
		cd.save(new TempCustomer());
		TempCustomer cu=cd.findById(customer_id).get();
		Plant splant=pd.findById(plantId).get();
		if(splant==null) {
//			Throw error
		}
		if(cu!=null) {
			
			cu.getOd().getPlantlist().add(splant);
			cu.getOd().setTotalprice(0);
			cd.save(cu);
			
			return cu.getOd();
			
		}
		else {
			throw new IllegalAccessError("Plant Cannot Registered");
		}
//	return new Plant();
	}

	@Override
	public Cart RemovePlantFromCart(Integer customer_id,Integer plantId) {
		// TODO Auto-generated method stub
		TempCustomer cu=cd.getById(customer_id);
		Plant splant=pd.getById(plantId);
		if(splant==null) {
//			Throw error
		}
		if(cu!=null) {
			
			cu.getOd().getPlantlist().add(splant);
			cd.save(cu);
			return cu.getOd();
			
		}
		else {
			throw new IllegalAccessError("Plant Cannot Registered");
		}
	
	}



	@Override
	public Orders CheckoutCart(Integer customer_id) {
		// TODO Auto-generated method stub
		Orders neword=new Orders();
		TempCustomer cu=cd.findById(customer_id).get();
		Cart co=cu.getOd();
		if(co.getTotalprice()==0) {
			throw new IllegalArgumentException("Add Something to Cart");
		}
		else {
			neword.setCustomer_id(customer_id);
			LocalDate dt=LocalDate.now();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			List<Plant> temp=co.getPlantlist();
			List<Plant> fin=neword.getPlantsbought();
			for(int i=0;i<temp.size();i++) {
				fin.add(temp.get(i));
			}
			neword.setOrderdate(dt);
			neword.setTotalitems(co.getTotalitems());
			neword.setTotalprice(co.getTotalprice());
			neword.setPlantsbought(fin);
			
			Orders finord=ord.save(neword);
			return finord;
		}
		
		
		
	}
	}

	
	
	

