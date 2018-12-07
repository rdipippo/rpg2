package com.deadsimple.rpg.repository;

import com.deadsimple.rpg.model.GameState;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameStateRepository extends MongoRepository<GameState, String> {
}
