package com.api.rest.rest_tutorial.infrastructure.mongo;

import com.api.rest.rest_tutorial.domain.pets.Pet;
import com.api.rest.rest_tutorial.repository.Repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoPetsRepository extends Repository<Pet>, MongoRepository<Pet, String> {

    Pet findBy_id(ObjectId _id);

    List<Pet> findAll();

    Pet save(Pet pet);

    void delete(Pet pet);
}