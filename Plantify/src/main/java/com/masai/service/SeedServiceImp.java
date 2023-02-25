package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.exception.SeedException;
import com.masai.model.Seed;
import com.masai.repository.SeedDao;

public class SeedServiceImp  implements SeedService{
	
	
	@Autowired
	private SeedDao sDao;

	@Override
	public Seed addSeed(Seed seed) throws SeedException {
		// TODO Auto-generated method stub
		
	   Seed saved =	sDao.save(seed);
		
		return saved;
	}

	@Override
	public Seed updateSeed(Seed seed) throws SeedException {
		// TODO Auto-generated method stub
		Optional<Seed> opt = sDao.findById(seed.getSeedId());
		
		if(opt.isPresent()) {
			 Seed uSeed =  opt.get();
			
			if(seed.getBloomTime() != null) {
				uSeed.setBloomTime(seed.getBloomTime());
			}
			
			if(seed.getSeedCost() != null) {
				uSeed.setSeedCost(seed.getSeedCost());
			}
			
			if(seed.getSeedPerPacket() != null) {
				uSeed.setSeedPerPacket(seed.getSeedPerPacket());
			}
			
			if(seed.getSeedDescription() != null) {
				 uSeed.setSeedDescription(seed.getSeedDescription());
			}
			
			if(seed.getSeedStock() != null) {
				 uSeed.setSeedCost(seed.getSeedCost());
			}
			
			if(seed.getTemperture() != null) {
				 uSeed.setTemperture(seed.getTemperture());
			}
			
			if(seed.getSeedType() != null) {
				 uSeed.setSeedType(seed.getSeedType());
			}
			if(seed.getSeedName() != null) {
				 uSeed.setSeedName(seed.getSeedName());
			}
			
			
		  return 	sDao.save(uSeed);
			
		}else
			throw new SeedException("There is no seed with this id"+seed.getSeedId());
		
		
		
	
	}

	@Override
	public List<Seed> getAllSeed() throws SeedException {
		// TODO Auto-generated method stub
		List<Seed> list = sDao.getAllSeed();
		
		if(list.size() != 0) {
			 return list;
		}else {
			throw new SeedException("Oops! There is no seed registered yet");
		}
		
	}

	@Override
	public Seed removeSeed(Integer seedId) throws SeedException {
		// TODO Auto-generated method stub
		 
		Optional<Seed> opt = sDao.findById(seedId);
		
		if(opt.isPresent()) {
			Seed seed = opt.get();
		    sDao.delete(seed);
		    return seed;
		   
		}else {
			throw new SeedException("Oops! There is no Seed with this id"+ seedId);
		}
		
		
	}
       
	
	
	
}
