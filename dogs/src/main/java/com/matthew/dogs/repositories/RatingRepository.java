package com.matthew.dogs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.dogs.models.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{

}
