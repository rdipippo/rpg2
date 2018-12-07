package com.deadsimple.rpg;

import com.deadsimple.rpg.repository.UserRepository;
import com.mongodb.MongoClient;
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
}
