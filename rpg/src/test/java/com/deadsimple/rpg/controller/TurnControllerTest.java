package com.deadsimple.rpg.controller;

import com.deadsimple.rpg.BaseTest;
import com.deadsimple.rpg.model.GameState;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TurnControllerTest extends BaseTest {
    @Autowired
    TurnController controller;

    @Test
    public void notEnoughTurns() {
        getGameState().setTurns(0);
        GameState newGameState = controller.takeTurn(getUser(), DEFAULT_TEST_ADVENTURE_AREA);

        Assert.assertEquals(0, newGameState.getTurns());
        Assert.assertEquals(1, newGameState.getMessages().size());
        Assert.assertEquals("You don't have enough turns to adventure here", newGameState.getMessages().get(0).getMessage());
    }
}
