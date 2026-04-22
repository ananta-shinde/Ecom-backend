package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Offer;
import com.example.demo.entities.User;
import com.example.demo.responses.AppResponse;
import com.example.demo.services.OfferService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OfferController {
	
	@Autowired
	OfferService offerService;
	
	AppResponse appResponse;
	
	public OfferController(AppResponse appResponse) {
		// TODO Auto-generated constructor stub
		this.appResponse = appResponse;
	}
	
	@PostMapping("api/v1/offer/new")
	public AppResponse creatOffer(@RequestBody Offer offer) {
		Offer createdoffer = offerService.create(offer);
		appResponse.put("status", 201);
		appResponse.put("id", createdoffer.getId());
		appResponse.put("message", "offer created successfully");
		
		return appResponse;
	}

	@PutMapping("/api/v1/offer/update")
	public AppResponse updateOffer(@RequestBody Offer offer) {
		Offer updatedOffer = offerService.update(offer);
		appResponse.put("status", 200);
		appResponse.put("message", "success");
		appResponse.put("offer", updatedOffer);
		return appResponse;
		
	}
	

	@GetMapping("/api/v1/offer/{id}")
	public AppResponse getOffer(@PathVariable Long id) {
		Offer offer = offerService.getById(id);
		if(offer != null) {
		appResponse.put("status", 200);
		appResponse.put("message", "success");
		appResponse.put("offer", offer);
		}else {
			appResponse.put("status", 404);
			appResponse.put("message", "not found");
			
		}
		return appResponse;
		
	}
	

	@GetMapping("/api/v1/offer")
	public AppResponse getAllOffers() {
		appResponse.put("offers", offerService.getList());
		appResponse.put("status", 200);
		return appResponse;	
	}
	
	@DeleteMapping("/api/v1/offer/delete/{id}")
	public AppResponse deleteOffer(@PathVariable Long id) {
		offerService.delete(id);
		appResponse.put("status", 200);
		appResponse.put("message", "successfully deleted");
		return appResponse;
	}
	
}
