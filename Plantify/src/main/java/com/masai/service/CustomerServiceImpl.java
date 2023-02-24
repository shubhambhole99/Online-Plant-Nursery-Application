//package com.masai.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.masai.model.Cart;
//import com.masai.model.Plant;
//import com.masai.model.TempCustomer;
//import com.masai.repository.CustomerDao;
//import com.masai.repository.PlantDao;
//
//@Service
//public class CustomerServiceImpl implements CustomerService{
//	@Autowired
//	CustomerDao cd;
//	@Autowired
//	PlantDao pd;
//	
//	
//	
//	public TempCustomer AddCustomer(TempCustomer cust) {
//		TempCustomer scus=cd.save(cust);
//		
//		return scus;
//		
//	}
//	
//	
//	
//	@Override
//	public Cart AddPlantToCart(Integer customer_id,Integer plantId) {
//		// TODO Auto-generated method stub
//		cd.save(new TempCustomer());
//		TempCustomer cu=cd.findById(customer_id).get();
//		Plant splant=pd.findById(plantId).get();
//		if(splant==null) {
////			Throw error
//		}
//		if(cu!=null) {
//			
//			cu.getOd().getPlantlist().add(splant);
//			cu.getOd().setTotalprice(0);
//			cd.save(cu);
//			
//			return cu.getOd();
//			
//		}
//		else {
//			throw new IllegalAccessError("Plant Cannot Registered");
//		}
////	return new Plant();
//	}
//
//	@Override
//	public Cart RemovePlantFromCart(Integer customer_id,Integer plantId) {
//		// TODO Auto-generated method stub
//		TempCustomer cu=cd.getById(customer_id);
//		Plant splant=pd.getById(plantId);
//		if(splant==null) {
////			Throw error
//		}
//		if(cu!=null) {
//			
//			cu.getOd().getPlantlist().add(splant);
//			cd.save(cu);
//			return cu.getOd();
//			
//		}
//		else {
//			throw new IllegalAccessError("Plant Cannot Registered");
//		}
//	
//	}
//	}
//
//	
//	
//	
//
