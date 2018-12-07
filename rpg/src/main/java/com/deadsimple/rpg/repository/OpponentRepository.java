package com.deadsimple.rpg.repository;

import com.deadsimple.rpg.model.Opponent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OpponentRepository extends MongoRepository<Opponent, String> {
}
