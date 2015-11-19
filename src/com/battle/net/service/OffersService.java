package com.battle.net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.battle.net.dao.Offer;
import com.battle.net.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDao;
	
	
	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}

	public List<Offer> getCurrent(){
		return offersDao.getOffers();    //  Selektina is DB
	}

	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public void create(Offer offer) {
		offersDao.saveAndUpdate(offer);		// Sukuria nauja irasa	
	}

	public boolean hasOffer(String name) {
		if(name == null){
			return false;
		}
		
		List<Offer> offers= offersDao.getOffers(name);
		
		if(offers.size()== 0){
			return false;
		}
		return true;
	}

	public Offer getOffer(String username) {
		if(username == null){
			return null;
		}
		List<Offer> offers= offersDao.getOffers(username);
		
		if(offers.size() == 0){
			return null;
		}
		return offers.get(0);
	}

	public void createUpdate(Offer offer){
			offersDao.saveAndUpdate(offer);
		}


	public void delete(int id) {
		offersDao.delete(id);
	}
}
