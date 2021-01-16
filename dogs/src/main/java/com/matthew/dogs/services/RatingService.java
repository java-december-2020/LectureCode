package com.matthew.dogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.dogs.models.Rating;
import com.matthew.dogs.repositories.RatingRepository;

@Service
public class RatingService {
	@Autowired
	private RatingRepository rRepo;
	
	public void createRating(Rating rating) {
		this.rRepo.save(rating);
	}
}
