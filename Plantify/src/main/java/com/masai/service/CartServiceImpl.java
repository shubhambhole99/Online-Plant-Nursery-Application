package com.masai.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.CartException;
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
//	Add To Cart //

	@Override
	public Cart AddPlantToCart(Integer customer_id,Integer plantId) {
		// TODO Auto-generated method stub
		Customer cu=cd.findById(customer_id).get();
		Plant splant=pd.findById(plantId).get();
		if(splant==null) {
			throw new PlantException("Plant Not Found");

		}
		if(cu!=null) {
//			if(cu.getOd().getPlantlist().contains(splant)) {
//				throw new PlantException("Plant Already Exists");
//			}
			cu.getOd().getPlantlist().add(splant);
			cd.save(cu);
			setpriceanditems(customer_id);
			return cu.getOd();
			
		}
		else {
			throw new CustomerException("Customer Not Found");
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
			if(cu.getOd().getPlanterlist().contains(splanter)) {
				throw new PlanterException("Plant Already Exists");
			}
			cu.getOd().getPlanterlist().add(splanter);
			cd.save(cu);
			setpriceanditems(customer_id);
			return cu.getOd();
			
		}
		else {
			throw new CustomerException("Customer Not Found");
		}
	}
//	Seed
	public Cart AddSeedToCart(Integer customer_id,Integer seedId) {
		// TODO Auto-generated method stub
		Customer cu=cd.findById(customer_id).get();
		Seed seed=sdo.findById(seedId).get();
		if(seed==null) {
			throw new SeedException("Seed not found");
		}
		if(cu!=null) {
			if(cu.getOd().getSeedlist().contains(seed)) {
				throw new SeedException("Plant Already Exists");
			}
			cu.getOd().getSeedlist().add(seed);
			
			cd.save(cu);
			setpriceanditems(customer_id);

			return cu.getOd();
			
		}
		else {
			throw new CustomerException("Customer Not Found");
		}
	}
//	Remove
	@Override
	public Cart RemovePlantFromCart(Integer customer_id,Integer plantId) {
		// TODO Auto-generated method stub
		Customer cu=cd.findById(customer_id).get();
		Plant splant=pd.findById(plantId).get();
		if(splant==null) {
			throw new PlantException("Plant Not Found");

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
			throw new CustomerException("Customer Not Found");
		}
	
	}
	@Override
	public Cart RemovePlanterFromCart(Integer customer_id,Integer planterId) {
		// TODO Auto-generated method stub
		Customer cu=cd.findById(customer_id).get();
		Planter planter=pld.findById(planterId).get();
		if(planter==null) {
			throw new PlanterException("Planter Not Found");

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
			throw new CustomerException("Customer Not Found");
		}
	
	}

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
			throw new CustomerException("Customer Not Found");
		}
	
	}

	



	@Override
	public Orders CheckoutCart(Integer customer_id) {
		// TODO Auto-generated method stub
		
		
		
		Customer cu=cd.findById(customer_id).get();
		Cart co=cu.getOd();
		if(co.getTotalprice()==0) {
			throw new CartException("Add Something to Cart");
		}
		else {
			Orders neword=new Orders();
			LocalDate dt=LocalDate.now();
			neword.setPlantsbought(new ArrayList());
			neword.setPlanterbought(new ArrayList());
			neword.setSeedbought(new ArrayList());
			
			neword.setOrderdate(dt);
			neword.setTotalitems(co.getTotalitems());
			neword.setTotalprice(co.getTotalprice());
			List<Plant> temp=co.getPlantlist();
			List<Planter> temp1=co.getPlanterlist();
			List<Seed> temp2=co.getSeedlist();
//			
			for(int i=0;i<temp.size();i++) {
				neword.getPlantsbought().add(temp.get(i));
			}
			for(int i=0;i<temp1.size();i++) {
				neword.getPlanterbought().add(temp1.get(i));
			}
			for(int i=0;i<temp2.size();i++) {
				neword.getSeedbought().add(temp2.get(i));
			}
//			
//			
			neword.setCus(cu);
			ord.save(neword);
			cu.getOl().add(neword);
			cd.save(cu);
			Cart ctn=new Cart();
			cu.setOd(ctn);
			cd.save(cu);
			
			
			
			return neword;
		}
		
		
		
	}
//	
	@Override
	public List<Orders> vieworderbyuserid(Integer cusid){
		Customer cu=cd.findById(cusid).get();
		
		List<Orders> al= cu.getOl();
		if(al!=null) {
			return al;
		}
	
	else {
		throw new CustomerException("Customer Not Found");
	}

	}
}

	

