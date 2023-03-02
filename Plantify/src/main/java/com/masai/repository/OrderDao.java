package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Orders;

@Repository
public interface OrderDao extends JpaRepository<Orders,Integer>{

//	@Query("select from Orders o where o.CustomerId=:cusid")
//	public List<Orders> findByCustomer(Integer cusid);
}
