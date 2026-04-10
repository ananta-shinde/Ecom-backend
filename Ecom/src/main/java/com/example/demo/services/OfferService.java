package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.OfferRepository;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;
}
