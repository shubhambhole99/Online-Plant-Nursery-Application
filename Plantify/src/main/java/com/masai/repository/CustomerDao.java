package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.TempCustomer;
@Repository
public interface CustomerDao extends JpaRepository<TempCustomer,Integer> {

}
