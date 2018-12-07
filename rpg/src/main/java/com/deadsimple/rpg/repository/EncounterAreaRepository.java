package com.deadsimple.rpg.repository;

import com.deadsimple.rpg.model.EncounterArea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EncounterAreaRepository extends MongoRepository<EncounterArea, String> {
    EncounterArea findByGameName(String gameName);
}
