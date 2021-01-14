package com.matthew.dogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.dogs.models.Toy;
import com.matthew.dogs.repositories.ToyRepository;

@Service
public class ToyService {
	@Autowired
	private ToyRepository tRepo;
	
	// Create
	public Toy create(Toy toy) {
		return this.tRepo.save(toy);
	}
}
