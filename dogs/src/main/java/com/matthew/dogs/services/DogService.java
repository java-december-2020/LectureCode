package com.matthew.dogs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matthew.dogs.models.Dog;
import com.matthew.dogs.models.User;
import com.matthew.dogs.repositories.DogRepository;

@Service
public class DogService {
	
	// Dependency Inject Dog Repository To Have Access to Crud and FindAll Methods
	private DogRepository dRepo;
	
	public DogService(DogRepository dogRepository) {
		this.dRepo = dogRepository;
	}
	
	// Retrieve All
	public List<Dog>  getAllDogs(){
		return this.dRepo.findAll();
	}
	
	// Create
	public Dog createDog(Dog newDog) {
		return this.dRepo.save(newDog);
	}
	
	public Dog createDog(String name, String breed, int age) {
		Dog newDog = new Dog(name, breed, age);
		return this.dRepo.save(newDog);
	}
	
	// Read
	public Dog getSingleDog(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	
	// Update
	public Dog updateDog(Dog updatedDog) {
		return this.dRepo.save(updatedDog);
	}	
	
	
	// Delete
	public void deleteDog(Long id) {
		this.dRepo.deleteById(id);
	}
	
	// Add Liker To Database
	public void addLiker(User user, Dog dog) {
	// Get The List From the Dog Object
		List<User> likers = dog.getLikers();
	// Add the Liker
		likers.add(user);
	// Update The Database
		this.dRepo.save(dog);
	}
	
	// Add Liker To Database
	public void removeLiker(User user, Dog dog) {
	// Get The List From the Dog Object
		List<User> likers = dog.getLikers();
	// Remove the Liker
		likers.remove(user);
	// Update The Database
		this.dRepo.save(dog);
	}
}
