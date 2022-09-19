package com.example.CPMO.repositories;

import com.example.CPMO.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

/*
TODO Database is temporary, when program is closed all data is lost, shouldn't be the case.
*/

public interface PetRepository extends JpaRepository<Pet, Long> {

}
