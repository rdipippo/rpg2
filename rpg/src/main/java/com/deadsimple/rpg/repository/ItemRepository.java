package com.deadsimple.rpg.repository;

import com.deadsimple.rpg.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
    Item findByGameName(String gameName);
}