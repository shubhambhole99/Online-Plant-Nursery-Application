////package com.masai.controller;
////
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.masai.model.Cart;
//import com.masai.model.Orders;
//import com.masai.model.TempCustomer;
//import com.masai.service.CustomerService;
//
//@RestController
//@RequestMapping("/customer")
//public class TempCustomerController {
//	@Autowired
//	private CustomerService cs;
//	
//	@GetMapping("/l")
//	public String tryid() {
//		return "s";
//	}
//	
//////@PostMapping("/plants/{cid}/{pid}")
////// public ResponseEntity<Plant> AddPlantCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid){
////////	ResponseEntity<Ca;rt>
//////	System.out.println(cid+""+pid);
//////	
//////	Plant ncart=cs.AddPlantToCart(cid, pid);
////////	 return cid+" "+pid;
//////	 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
//////	 
//////	 
////// }
////	
////@PostMapping("/customer")
////public ResponseEntity<TempCustomer> AddCustomerHandler(@RequestBody TempCustomer Cust){
////	
////	TempCustomer scus=cs.AddCustomer(Cust);
////	return new ResponseEntity<>(scus,HttpStatus.CREATED);
////	
////}
////
////	
////@PostMapping("/plants/{cid}/{pid}")
////public ResponseEntity<Cart> AddPlantCartHandler(@PathVariable("cid")Integer cid,@PathVariable("pid")Integer pid){
//////	ResponseEntity<Ca;rt>
////	System.out.println(cid+""+pid);
////	
////	Cart ncart=cs.AddPlantToCart(cid, pid);
//////	 return cid+" "+pid;
////	 return new ResponseEntity<>(ncart,HttpStatus.CREATED);
////	 
////	 
////}
////@PostMapping("/Orders/{cid}")
////public ResponseEntity<Orders> PlaceOrderHandler(@PathVariable("cid")Integer cid){
////	 
////	Orders ord=cs.CheckoutCart(cid);
////	return new ResponseEntity<>(ord,HttpStatus.CREATED);
////	
////}
////
//}
