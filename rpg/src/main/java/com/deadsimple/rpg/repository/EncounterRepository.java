package com.deadsimple.rpg.repository;

import com.deadsimple.rpg.model.Encounter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EncounterRepository extends MongoRepository<Encounter, String> {
}
