package com.deadsimple.rpg;

import com.deadsimple.rpg.repository.UserRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RpgApplication.class)
public class RpgApplicationTests {

	@Autowired
	UserDetailsService udService;

	@Autowired
	private MongoClient mongoClient;

	@Autowired
	UserRepository repo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testLogin() {
		MongoDatabase database = mongoClient.getDatabase("rpg");
		MongoCollection<Document> collection = database.getCollection("users");
		Document user = new Document();
		user.put("username", "rjdipippo@gmail.com");
		user.put("password", "12345");

		collection.insertOne(user);
		udService.loadUserByUsername("rjdipippo@gmail.com");
	}
}
