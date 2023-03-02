package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.UserSessionException;
import com.masai.model.Cart;
import com.masai.model.Orders;
import com.masai.service.CartService;
import com.security.model.UserSession;
import com.security.model.UserType;
import com.security.service.Authentication;

@RestController
@RequestMapping("/cart")
public class CartController {


	@Autowired
	private CartService cs;
	
	@Autowired
	   private Authentication auth;
	
	@PostMapping("/addplanttocart/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> AddPlantCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key) throws Exception {

//		System.out.println(cid+""+pid);
		UserSession uSession =   auth.authenticate(key);
		 if(uSession.getUser().equals(UserType.USER) && cid==uSession.getUserId()) {
			 Cart ncart=cs.AddPlantToCart(cid, pid);
			 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		 }
		 else {
		     throw new UserSessionException("Oops! You are not logged in");
	  }
		

		 
		 
		 
	}
	@PostMapping("/addplantertocart/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> AddPlanterCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key) throws Exception{

//		System.out.println(cid+""+pid);
		UserSession uSession =   auth.authenticate(key);
		 if(uSession.getUser().equals(UserType.USER) && cid==uSession.getUserId()) {
		Cart ncart=cs.AddPlanterToCart(cid, pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		 }
		 else {
		     throw new UserSessionException("Oops! You are not logged in");
	  }
		 
	}
	@PostMapping("/addseedtocart/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> AddSeedCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key) throws Exception{

//		System.out.println(cid+""+pid);
		UserSession uSession =  auth.authenticate(key);
		if(uSession.getUser().equals(UserType.USER) && cid==uSession.getUserId()) {
			Cart ncart=cs.AddSeedToCart(cid, pid);

			 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
			 }
	
		else {
		     throw new UserSessionException("Oops! You are not logged in");
	  }
		 
	}
	@DeleteMapping("/removeplantfromcart/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> RemovePlantCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key) throws Exception{

//		System.out.println(cid+""+pid);
		UserSession uSession =   auth.authenticate(key);
		if(uSession.getUser().equals(UserType.USER) && cid==uSession.getUserId()) {

		Cart ncart=cs.RemovePlantFromCart(cid,pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		}else {
		     throw new UserSessionException("Oops! You are not logged in");
	  }
		 
	}
	@DeleteMapping("/removeplanterfromcart/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> RemovePlanterCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key) throws Exception{

//		System.out.println(cid+""+pid);
		UserSession uSession =   auth.authenticate(key);
		if(uSession.getUser().equals(UserType.USER) && cid==uSession.getUserId()) {

		Cart ncart=cs.RemovePlanterFromCart(cid,pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		}
		else {
		     throw new UserSessionException("Oops! You are not logged in");
	  }
		 
	}
	@DeleteMapping("/removeseedfromcart/{cid}/{pid}/{key}")
	public ResponseEntity<Cart> RemoveSeedCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid,@PathVariable("key")String key) throws Exception{

//		System.out.println(cid+""+pid);
		UserSession uSession =   auth.authenticate(key);
		if(uSession.getUser().equals(UserType.USER) && cid==uSession.getUserId()) {

		Cart ncart=cs.RemoveSeedFromCart(cid,pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		} 
		else {
		     throw new UserSessionException("Oops! You are not logged in");
	  }
		 
	}
	@PostMapping("/placeorder/{cid}/{key}")
public ResponseEntity<Orders> PlaceOrderHandler(@PathVariable("cid")Integer cid,@PathVariable("key")String key) throws Exception{
	UserSession uSession =   auth.authenticate(key);
//	 && cid==uSession.getUserId()
	if(uSession.getUser().equals(UserType.USER)) {

	Orders ord=cs.CheckoutCart(cid);
	return new ResponseEntity<>(ord,HttpStatus.CREATED);
	}
	else {
	     throw new UserSessionException("Oops! You are not logged in");
 }
}
	@PostMapping("/getorderhistory/{cid}/{key}")
	public ResponseEntity<List<Orders>> GetOrderbyidHandler(@PathVariable("cid")Integer cid,@PathVariable("key")String key) throws Exception{
		UserSession uSession =   auth.authenticate(key);
		if(uSession.getUser().equals(UserType.ADMIN)) {
			List<Orders> al=cs.vieworderbyuserid(cid);
		
		return new ResponseEntity<>(al,HttpStatus.CREATED);
		}
		else if(uSession.getUser().equals(UserType.USER) && cid==uSession.getUserId()) {
			List<Orders> al1=cs.vieworderbyuserid(cid);
				return new ResponseEntity<>(al1,HttpStatus.CREATED);
		}
		else {
		     throw new UserSessionException("Oops! You are not logged in");
	 }
	}
}
