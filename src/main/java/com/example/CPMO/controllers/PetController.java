package com.example.CPMO.controllers;

import com.example.CPMO.Pet;
import com.example.CPMO.repositories.PetRepository;
import com.example.CPMO.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PetController {

    private PetRepository petRep;

    // POST upload image
    @PostMapping("/pet/{petId}/uploadImage")
    public ResponseEntity<Pet> postPetImage(@PathVariable Long petId, @RequestBody Map<String,String> url){ // Map to access url inside entire RequestBody
        Pet updatePet = petRep.findById(petId)
                .orElseThrow(() -> new ResourceNotFoundException("Pet doesn't exist with ID: " + petId));

        updatePet.photoUrlsAdd(url.get("url"));
        petRep.save(updatePet);

        return ResponseEntity.ok(updatePet);
    }

    // POST new pet
    // Required fields only id and photoUrls?
    @PostMapping("/pet")
    public Pet postPet(@RequestBody Pet pet){
        return petRep.save(pet);
    }

    // PUT existing pet
    // TODO update pet without overwriting old proper values with new null values
    @PutMapping("/pet") // missing id in path?
    public ResponseEntity<Pet> putPet(@RequestBody Pet pet){
        Pet updatePet = petRep.findById(pet.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Pet doesn't exist with ID: " + pet.getId()));
                // TODO error codes? prettier error message?
        updatePet.setPhotoUrls(pet.getPhotoUrls()); // very repetitive, is there a better way?
        updatePet.setCategory(pet.getCategory()); // copy constructor? clone?
        updatePet.setId(pet.getId());
        updatePet.setName(pet.getName());
        updatePet.setStatus(pet.getStatus());
        updatePet.setTags(pet.getTags());

        petRep.save(updatePet);

        return ResponseEntity.ok(updatePet);
    }

    // GET all pets
    @GetMapping("/pet")
    public List<Pet> getPets(){
        return petRep.findAll();
    }

    /*
    // GET by id
    // TODO Multiple different status
    @GetMapping("/pet/findByStatus")
    public List<Pet> getPetsbyStatus(@RequestBody Map<String,String> status){
        return petRep.findBy() // implement special function in PetRepository
    }
    */

    @GetMapping("/pet/{id}")
    public Optional<Pet> getPetById(@PathVariable Long id){
        return petRep.findById(id);
    }

    @DeleteMapping("/pet/{id}")
    public void deletePet(@PathVariable Long id){
        petRep.deleteById(id);
    }

}
