package com.matthew.dogs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.dogs.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{

}
