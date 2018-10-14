package com.api.rest.rest_tutorial.rest;

import com.api.rest.rest_tutorial.models.Pets;
import org.bson.types.ObjectId;
import com.api.rest.rest_tutorial.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private PetsRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Pets> getAllPets() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pets getPetById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id,
                              @Valid @RequestBody Pets pets) {
        pets.set_id(id);
        repository.save(pets);
    }
    @RequestMapping(method = RequestMethod.POST)
//    @PostMapping()
    public Pets createPet(@Valid @RequestBody Pets pets) {
        pets.set_id(ObjectId.get());
        repository.save(pets);
        return pets;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePetById(@PathVariable("id") ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}
