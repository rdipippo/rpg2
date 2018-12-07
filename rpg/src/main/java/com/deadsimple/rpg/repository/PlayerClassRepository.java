package com.deadsimple.rpg.repository;

import com.deadsimple.rpg.model.PlayerClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerClassRepository extends MongoRepository<PlayerClass, String> {
}
