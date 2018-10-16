package com.api.rest.rest_tutorial.action;

import com.api.rest.rest_tutorial.domain.pets.Pet;
import com.api.rest.rest_tutorial.repository.Repository;
import org.bson.types.ObjectId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CreatePet {
    private final Repository repository;
    final Logger logger = LoggerFactory.getLogger(CreatePet.class);

    public CreatePet(Repository repository) {
        this.repository = repository;
    }

    public Pet invoke(Pet pet) throws PetsExistException {
        validateNonExistenceOfPet(pet);

        pet.set_id(ObjectId.get());
        repository.save(pet);
        return pet;
    }

    private void validateNonExistenceOfPet(Pet pet) throws PetsExistException {
        List<Pet> petCollection = repository.findAll();
        if (petCollection.stream().anyMatch(p -> p.name.equals(pet.name))){
            logger.debug("Pet Exist in collection");
            throw new PetsExistException("Pet exist.");
        }
    }

    public class PetsExistException extends Throwable {
        public PetsExistException(String message) {
        }
    }
}