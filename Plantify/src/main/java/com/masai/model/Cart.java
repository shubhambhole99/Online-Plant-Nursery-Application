package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToOne;


public class Cart{
	
	private Integer totalprice=0;
	private Integer totalitems;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JsonIgnore
//	private Customer customer;
	
	@Embedded
	@ElementCollection
	private List<Plant> plantlist;
//	
//	

	public Integer getTotalprice() {
		return totalprice;
	}

	
	public Integer getTotalitems() {
		return totalitems;
	}

	public void setTotalitems(Integer totalitems) {
		this.totalitems = totalitems;
	}

	public List<Plant> getPlantlist() {
		return plantlist;
	}

	public void setPlantlist(List<Plant> plantlist) {
		this.plantlist = plantlist;
	}


//	public void setTotalprice(Integer totalprice) {
//		this.totalprice = totalprice;
//	}


//
	public void setTotalprice(Integer totalprice) {
		List<Plant> p=this.plantlist;
		int cd=0;
		if(p!=null) {
		for(int i=0;i<p.size();i++) {
			cd+=p.get(i).getPlantcost();
		}
		this.totalprice=cd;
	}
	}



	

	
//	{
//	    "od":{
//	        "totalprice":1,
//	        "totalitems":0,
//	        "plantlist":[]
//	    }
//	}
}
