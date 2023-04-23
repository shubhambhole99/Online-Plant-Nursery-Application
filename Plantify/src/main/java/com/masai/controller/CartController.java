package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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

@RestController
@EnableMethodSecurity
@RequestMapping("/cart")
public class CartController {


	@Autowired
	private CartService cs;
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addplanttocart/{cid}/{pid}")
	public ResponseEntity<Cart> AddPlantCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid) throws Exception {

//		System.out.println(cid+""+pid);
	
	
			 Cart ncart=cs.AddPlantToCart(cid, pid);
			 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
	
	  }
		
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addplantertocart/{cid}/{pid}")
	public ResponseEntity<Cart> AddPlanterCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid) throws Exception{


		Cart ncart=cs.AddPlanterToCart(cid, pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		 }
		
		 
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addseedtocart/{cid}/{pid}")
	public ResponseEntity<Cart> AddSeedCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid) throws Exception{

//		System.out.println(cid+""+pid);
		
			Cart ncart=cs.AddSeedToCart(cid, pid);
			return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		 
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping("/removeplantfromcart/{cid}/{pid}")
	public ResponseEntity<Cart> RemovePlantCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid) throws Exception{

//		
		Cart ncart=cs.RemovePlantFromCart(cid,pid);
		return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		 
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping("/removeplanterfromcart/{cid}/{pid}")
	public ResponseEntity<Cart> RemovePlanterCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid) throws Exception{

//		System.out.println(cid+""+pid);
		
		Cart ncart=cs.RemovePlanterFromCart(cid,pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		}
	
		 
	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping("/removeseedfromcart/{cid}/{pid}")
	public ResponseEntity<Cart> RemoveSeedCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid) throws Exception{


		Cart ncart=cs.RemoveSeedFromCart(cid,pid);

		 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
		} 
	
		 
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/placeorder/{cid}")
public ResponseEntity<Orders> PlaceOrderHandler(@PathVariable("cid")Integer cid) throws Exception{

	Orders ord=cs.CheckoutCart(cid);
	return new ResponseEntity<>(ord,HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/getorderhistory/{cid}")
	public ResponseEntity<List<Orders>> GetOrderbyidHandler(@PathVariable("cid")Integer cid) throws Exception{
	
			List<Orders> al1=cs.vieworderbyuserid(cid);
				return new ResponseEntity<>(al1,HttpStatus.CREATED);
		

	}
}
