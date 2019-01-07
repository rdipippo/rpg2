package com.deadsimple.rpg.controller;

import com.deadsimple.rpg.BaseTest;
import com.deadsimple.rpg.model.GameState;
import com.deadsimple.rpg.model.PlayerAction;
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

    @Test
    public void basicEncounter() {
        GameState newGameState = controller.takeTurn(getUser(), DEFAULT_TEST_ADVENTURE_AREA);
        Assert.assertNotNull(newGameState.getCurrentEncounter());

        System.out.println(newGameState.getCurrentEncounter().getOpeningText());

        Assert.assertEquals(2, newGameState.getCurrentEncounter().getActions().size());
        Assert.assertEquals(0, newGameState.getMessages().size());

        for (PlayerAction action : newGameState.getCurrentEncounter().getActions()) {
            System.out.println(action.getName());
        }
    }

    @Test
    public void combatEncounter() {
        GameState newGameState = controller.takeTurn(getUser(), DEFAULT_TEST_ADVENTURE_AREA);
    }
}
