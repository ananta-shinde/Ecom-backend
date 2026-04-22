package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Offer;
import com.example.demo.repositories.OfferRepository;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	public Offer create(Offer offer) {
		 return offerRepository.save(offer);
	}
	
	public Offer update(Offer offer) {
		 return offerRepository.save(offer);
	}
	
	public List<Offer> getList(){
		return offerRepository.findAll();
	}
	
	public Offer getById(Long id){
		return offerRepository.getById(id);
	}
	
	public void delete(Long id){
		offerRepository.deleteById(id);
	}
	

}
