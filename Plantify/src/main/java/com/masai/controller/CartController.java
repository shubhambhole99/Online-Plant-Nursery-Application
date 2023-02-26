package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Cart;
import com.masai.model.Orders;
import com.masai.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {


	@Autowired
	CartService cs;
	
	@PostMapping("/plants/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> AddPlantCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key){

//		System.out.println(cid+""+pid);
		
		Cart ncart=cs.AddPlantToCart(cid, pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		 
		 
	}
	@PostMapping("/planter/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> AddPlanterCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key){

//		System.out.println(cid+""+pid);
		
		Cart ncart=cs.AddPlanterToCart(cid, pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		 
		 
	}
	@PostMapping("/seed/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> AddSeedCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key){

//		System.out.println(cid+""+pid);
		
		Cart ncart=cs.AddSeedToCart(cid, pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		 
		 
	}
	@DeleteMapping("/plant/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> RemovePlantCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key){

//		System.out.println(cid+""+pid);
		
		Cart ncart=cs.RemovePlantFromCart(cid,pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		 
		 
	}
	@DeleteMapping("/planter/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> RemovePlanterCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key){

//		System.out.println(cid+""+pid);
		
		Cart ncart=cs.RemovePlanterFromCart(cid,pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		 
		 
	}
	@DeleteMapping("/seed/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> RemoveSeedCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key){

//		System.out.println(cid+""+pid);
		
		Cart ncart=cs.RemoveSeedFromCart(cid,pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		 
		 
	}
	@PostMapping("/orders/{cid}")
public ResponseEntity<Orders> PlaceOrderHandler(@PathVariable("cid")Integer cid){
	 
	Orders ord=cs.CheckoutCart(cid);
	return new ResponseEntity<>(ord,HttpStatus.CREATED);
	
}
	
}
