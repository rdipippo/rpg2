package com.deadsimple.rpg.repository;

import com.deadsimple.rpg.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findByUsername(String email);
}


