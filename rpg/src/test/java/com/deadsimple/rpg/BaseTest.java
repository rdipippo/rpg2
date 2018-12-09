package com.deadsimple.rpg;

import com.deadsimple.rpg.model.EncounterArea;
import com.deadsimple.rpg.model.GameState;
import com.deadsimple.rpg.model.User;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RpgApplication.class)
public abstract class BaseTest {
    @Autowired
    MongoTemplate template;

    User user;

    GameState gs;

    EncounterArea ea;

    protected final String DEFAULT_TEST_ADVENTURE_AREA = "dungeonOfInfiniteTesting";

    protected GameState getGameState() {
        return this.gs;
    }

    protected User getUser() {
        return this.user;
    }

    @Before
    public void basicSetup() {
        gs = GameState.initNewPlayer();
        template.save(gs);

        user = new User();
        user.setUsername("unittest");
        user.setPassword("12345");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setGameState(gs);
        template.save(user);

        ea = new EncounterArea();
        ea.setName("Dungeon of Infinite Testing");
        ea.setTurnCost(1);
        ea.setGameName(DEFAULT_TEST_ADVENTURE_AREA);
        template.save(ea);
    }
}
