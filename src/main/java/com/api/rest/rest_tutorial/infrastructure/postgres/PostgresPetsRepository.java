package com.api.rest.rest_tutorial.infrastructure.postgres;

import com.api.rest.rest_tutorial.domain.pets.Pet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostgresPetsRepository {

    @Query("SELECT e FROM pets e where e.id=?")
    Pet findBy_id(ObjectId _id);

    List<Pet> findAll();

    Pet save(Pet pet);

    void delete(Pet pet);
}


//public interface MongoPetsRepository extends MongoRepository<Pet, String> {
//
//    Pet findBy_id(ObjectId _id);
//
//    List<Pet> findAll();
//
//    Pet save(Pet pets);
//
//    void delete(Pet pets);
//}