package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {
        
	@Query("from Customer c where c.username=:username and c.password=:password")
	public Customer getByUsernameAndByPassword(String username, String password);
}
