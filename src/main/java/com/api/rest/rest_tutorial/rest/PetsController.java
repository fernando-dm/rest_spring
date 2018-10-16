package com.api.rest.rest_tutorial.rest;
import com.api.rest.rest_tutorial.action.CreatePet;
import com.api.rest.rest_tutorial.domain.pets.Pet;
import org.bson.types.ObjectId;
import com.api.rest.rest_tutorial.infrastructure.mongo.MongoPetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

//TODO cada endpoint debe llamar a un action, hacer un versionador del controller v1: mongo, v2: postgres

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private MongoPetsRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Pet> getAllPets() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pet getPetById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id,
                              @Valid @RequestBody Pet pet) {
        pet.set_id(id);
        repository.save(pet);
    }

    @RequestMapping(method = RequestMethod.POST)
//    @PostMapping()
    public Pet createPet(@Valid @RequestBody Pet pet) {

        try {
            Pet petCreated = new CreatePet(repository).invoke(pet);
            return petCreated;

        } catch (CreatePet.PetsExistException e) {
            e.printStackTrace();
        }
        return pet;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePetById(@PathVariable("id") ObjectId id) {

        repository.delete(repository.findBy_id(id));
    }
}
