package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.CustomerException;
import com.exception.PlantException;
import com.exception.PlanterException;
import com.exception.SeedException;
import com.masai.model.Cart;
import com.masai.model.Customer;
import com.masai.model.Orders;
import com.masai.model.Plant;
import com.masai.model.Seed;
import com.masai.model.TempCustomer;
import com.masai.repository.CustomerDao;
import com.masai.repository.OrderDao;
import com.masai.repository.PlantDao;
import com.masai.repository.SeedDao;
import com.model.Planter;
import com.repository.PlanterDao;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CustomerDao cd;
	@Autowired
	PlantDao pd;
	
	@Autowired
	PlanterDao pld;
	
	@Autowired
	OrderDao ord;
	
	@Autowired
	SeedDao sdo;
	

	
//	Add To Cart //
// Plant
	@Override
	public Cart AddPlantToCart(Integer customer_id,Integer plantId) {
		// TODO Auto-generated method stub
		Customer cu=cd.findById(customer_id).get();
		Plant splant=pd.findById(plantId).get();
		if(splant==null) {
			throw new PlantException("No seed Found");

		}
		if(cu!=null) {
			
			cu.getOd().getPlantlist().add(splant);
			
			cd.save(cu);
			
			return cu.getOd();
			
		}
		else {
			throw new IllegalAccessError("Plant Cannot Registered");
		}
//	return new Plant();
	}
//	Planter
	@Override
	public Cart AddPlanterToCart(Integer customer_id,Integer planterId) {
		// TODO Auto-generated method stub
		Customer cu=cd.findById(customer_id).get();
		Planter splanter=pld.findById(planterId).get();
		if(splanter==null) {
			throw new PlanterException("Planter Not Found");
		}
		if(cu!=null) {
			
			cu.getOd().getPlanterlist().add(splanter);
			
			cd.save(cu);
			
			return cu.getOd();
			
		}
		else {
			throw new IllegalAccessError("Plant Cannot Registered");
		}
	}
//	Seed
	public Cart AddSeedToCart(Integer customer_id,Integer planterId) {
		// TODO Auto-generated method stub
		Customer cu=cd.findById(customer_id).get();
		Seed seed=sdo.findById(planterId).get();
		if(seed==null) {
			throw new SeedException("No seed Found");
		}
		if(cu!=null) {
			
			cu.getOd().getPlantlist().add(splanter);
			
			cd.save(cu);
			
			return cu.getOd();
			
		}
		else {
			throw new IllegalAccessError("Plant Cannot Registered");
		}
	}
//	Remove

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



	@Override
	public String addCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Customer getCustomerById(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Customer deleteCustomerById(Integer id) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Customer> getAllCustomer() throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Customer getCustomerByUserNameAnsPassword(String username, String password) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}
	}

	
	
	

