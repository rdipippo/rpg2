package com.deadsimple.rpg;

import com.deadsimple.rpg.model.GameState;
import com.deadsimple.rpg.repository.UserRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RpgApplication.class)
public class RpgApplicationTests {

	@Autowired
	UserDetailsService udService;

	@Autowired
	private MongoTemplate mongoClient;

	@Autowired
	UserRepository repo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void inventoryAsRawDbObject() {
		GameState gs = new GameState();
		BasicDBObject inventory = new BasicDBObject();
		inventory.put("Long Sword", 3);
		inventory.put("Short Sword", 45);
		inventory.put("Potion of extra healing", 134);
		gs.setInventory(inventory);
		mongoClient.save(gs);
		GameState savedGs = mongoClient.findOne(new Query(), GameState.class);
		boolean dsh = true;
	}
}
