package com.api.rest.rest_tutorial.infrastructure.mongo;

import com.api.rest.rest_tutorial.domain.users.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MongoUsersRepository extends MongoRepository<Users,String> {

    Users findByUsername(String username);

    Users findBy_id(ObjectId _id);

    List<Users> findAll();

    Users save(Users users);

    void delete(Users users);
}
