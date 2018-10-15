package com.api.rest.rest_tutorial.repository.postgres;

import com.api.rest.rest_tutorial.models.pets.Pets;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostgresPetsRepository {

    @Query("SELECT e FROM pets e where e.id=?")
    Pets findBy_id(ObjectId _id);

    List<Pets> findAll();

    Pets save(Pets pets);

    void delete(Pets pets);
}


//public interface MongoPetsRepository extends MongoRepository<Pets, String> {
//
//    Pets findBy_id(ObjectId _id);
//
//    List<Pets> findAll();
//
//    Pets save(Pets pets);
//
//    void delete(Pets pets);
//}