package com.deadsimple.rpg;

import com.deadsimple.rpg.encounters.DummyTestEncounter;
import com.deadsimple.rpg.model.*;
import org.assertj.core.util.Lists;
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

        // TODO each test should be able to setup its own encounter
        DummyTestEncounter bte = new DummyTestEncounter();
        bte.setOpeningText("You are in a maze of twisty passages, all alike.");
        PlayerAction runAway = new PlayerAction();
        runAway.setName("Run Away");
        PlayerAction pressOn = new PlayerAction();
        pressOn.setName("Press on");
        bte.setActions(Lists.newArrayList(runAway, pressOn));
        template.save(bte);

        ea = new EncounterArea();
        ea.setName("Dungeon of Infinite Testing");
        ea.setTurnCost(1);
        ea.setGameName(DEFAULT_TEST_ADVENTURE_AREA);
        ea.setEncounters(Lists.newArrayList(bte));
        template.save(ea);
    }
}
