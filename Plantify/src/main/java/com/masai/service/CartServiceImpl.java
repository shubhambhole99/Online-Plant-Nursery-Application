package com.masai.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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
			
			setpriceanditems(customer_id);
			
			
			return cu.getOd();
			
		}
		else {
			throw new IllegalAccessError("Plant Cannot Registered");
		}
//	return new Plant();
	}

	public void setpriceanditems(Integer customer_id) {
		Customer cu=cd.findById(customer_id).get();
		Cart cart=cu.getOd();
//		
		List<Plant> pl=cart.getPlantlist();
		List<Planter> pl1=cart.getPlanterlist();
		List<Seed> pl2=cart.getSeedlist();
		int price=0;
		int items=0;
//		for (Entry<Plant, Integer> e : pl.entrySet()){
//			price+=e.getKey().getPlantcost()*e.getValue();
//			items+=e.getValue();
//
//		}
//		for (Entry<Planter, Integer> e : pl1.entrySet()){
//			price+=e.getKey().getPlanterCost()*e.getValue();
//			items+=e.getValue();
//
//		}
//		for (Entry<Seed, Integer> e : pl2.entrySet()){
//			price+=e.getKey().getSeedCost()*e.getValue();
//			items+=e.getValue();
//
//		}
		for(int i=0;i<pl.size();i++) {
			price+=pl.get(i).getPlantcost();
		}
		for(int i=0;i<pl1.size();i++) {
			price+=pl1.get(i).getPlanterCost();
		}
		for(int i=0;i<pl2.size();i++) {
			price+=pl2.get(i).getSeedCost();
		}
		items=pl.size()+pl1.size()+pl2.size();


		
	
	cart.setTotalitems(items);
	cart.setTotalprice(price);	
	cu.setOd(cart);
	cd.save(cu);
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
			setpriceanditems(customer_id);
			return cu.getOd();
			
		}
		else {
			throw new IllegalAccessError("Plant Cannot Registered");
		}
	}
//	Seed
	public Cart AddSeedToCart(Integer customer_id,Integer seedId) {
		// TODO Auto-generated method stub
		Customer cu=cd.findById(customer_id).get();
		Seed seed=sdo.findById(seedId).get();
		if(seed==null) {
			throw new SeedException("No seed Found");
		}
		if(cu!=null) {
			
			cu.getOd().getSeedlist().add(seed);
			
			cd.save(cu);
			setpriceanditems(customer_id);

			return cu.getOd();
			
		}
		else {
			throw new IllegalAccessError("Plant Cannot Registered");
		}
	}
//	Remove

	@Override
	public Cart RemovePlanterFromCart(Integer customer_id,Integer planterId) {
		// TODO Auto-generated method stub
		Customer cu=cd.findById(customer_id).get();
		Planter planter=pld.findById(planterId).get();
		if(planter==null) {
			throw new PlantException("No seed Found");

		}
		if(cu!=null) {
			int c=0;
			List<Planter> pl=cu.getOd().getPlanterlist();
//			for(int i=0;i<pl.size();i++) {
//				if(pl.get(i).getPlanterId()==planterId) {
//					c++;
//				}
//			}
//			if(q>c) {
//				throw new PlantException("Not Enough Quantity");
//			}
//			else {
//				int c1=0;
//				for(int i=0;i<pl.size();i++) {
//					if(pl.get(i).getPlanterId()==planterId) {
//						pl.remove(i);
//						c1++;
//						if(c1==q) {
//							break;
//						}
//					}
//				}
//				cu.getOd().setPlanterlist(pl);
//			}
			pl.remove(planter);
			cd.save(cu);
			setpriceanditems(customer_id);

			return cu.getOd();
			
		}
		else {
			throw new IllegalAccessError("Plant Cannot Registered");
		}
	
	}
//	Planter
	@Override
	public Cart RemoveSeedFromCart(Integer customer_id,Integer seedId) {
		// TODO Auto-generated method stub
		Customer cu=cd.findById(customer_id).get();
		Seed seed=sdo.findById(seedId).get();
		if(seed==null) {
			throw new SeedException("No seed Found");

		}
		if(cu!=null) {
			int c=0;
			List<Seed> pl=cu.getOd().getSeedlist();
//			for(int i=0;i<pl.size();i++) {
//				if(pl.get(i).getSeedId()==seedId) {
//					c++;
//				}
//			}
//			if(q>c) {
//				throw new PlantException("Not Enough Quantity");
//			}
//			else {
//				int c1=0;
//				for(int i=0;i<pl.size();i++) {
//					if(pl.get(i).getSeedId()==seedId) {
//						pl.remove(i);
//						c1++;
//						if(c1==q) {
//							break;
//						}
//					}
//				}
//				cu.getOd().setSeedlist(pl);
			
			pl.remove(seed);
			cd.save(cu);
			setpriceanditems(customer_id);

			return cu.getOd();
			
		}
		else {
			throw new IllegalAccessError("Plant Cannot Registered");
		}
	
	}
//	Seed
	@Override
	public Cart RemovePlantFromCart(Integer customer_id,Integer plantId) {
		// TODO Auto-generated method stub
		Customer cu=cd.findById(customer_id).get();
		Plant splant=pd.findById(plantId).get();
		if(splant==null) {
			throw new PlantException("No seed Found");

		}
		if(cu!=null) {
			int c=0;
			List<Plant> pl=cu.getOd().getPlantlist();
//			for(int i=0;i<pl.size();i++) {
//				if(pl.get(i).getPlant_id()==plantId) {
//					c++;
//				}
//			}
//			if(q>c) {
//				throw new PlantException("Not Enough Quantity");
//			}
//			else {
//				int c1=0;
//				for(int i=0;i<pl.size();i++) {
//					if(pl.get(i).getPlant_id()==plantId) {
//						pl.remove(i);
//						c1++;
//						if(c1==q) {
//							break;
//						}
//					}
//				}
//				cu.getOd().setPlantlist(pl);
//			}
				pl.remove(splant);
			cd.save(cu);
			setpriceanditems(customer_id);

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
		Customer cu=cd.findById(customer_id).get();
		Cart co=cu.getOd();
		if(co.getTotalprice()==0) {
			throw new IllegalArgumentException("Add Something to Cart");
		}
		else {
			neword.setCustomer_id(customer_id);
			LocalDate dt=LocalDate.now();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			List<Plant> temp=co.getPlantlist();
			List<Planter> temp1=co.getPlanterlist();
			List<Seed> temp2=co.getSeedlist();
			
			List<Plant> fin=neword.getPlantsbought();
			List<Planter> fin1=neword.getPlanterbought();
			List<Seed> fin2=neword.getSeedbought();

			for(int i=0;i<temp.size();i++) {
				fin.add(temp.get(i));
			}
			for(int i=0;i<temp1.size();i++) {
				fin1.add(temp1.get(i));
			}
			for(int i=0;i<temp2.size();i++) {
				fin2.add(temp2.get(i));
			}
			
			neword.setOrderdate(dt);
			neword.setTotalitems(co.getTotalitems());
			neword.setTotalprice(co.getTotalprice());
			neword.setPlantsbought(fin);
			neword.setPlanterbought(fin1);
			neword.setSeedbought(fin2);
			Cart ctn=new Cart();
			cu.setOd(ctn);
			cd.save(cu);
			Orders finord=ord.save(neword);
			return finord;
		}
		
		
		
	}
	


	}

	
	
	

