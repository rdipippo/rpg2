package com.deadsimple.rpg.model;

import com.deadsimple.rpg.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasicEffectTest extends BaseTest {
    BasicEffect effect = new BasicEffect();

    @Before
    public void before() {

    }

    @Test
    public void applyThenUnapplyLinearModifier() {
        GameState gameState = getGameState();
        effect.setModifier(10);
        effect.setGameStateField("attack");
        effect.setType(BasicEffect.BasicEffectType.LINEAR);

        effect.apply(gameState);

        Assert.assertEquals(20, gameState.getAttack().getModifiedValue());

        effect.unapply(gameState);

        Assert.assertEquals(10, gameState.getAttack().getModifiedValue());
    }

    @Test
    public void applyThenUnapplyPercentModifier() {
        GameState gameState = getGameState();
        effect.setModifier(10);
        effect.setGameStateField("attack");
        effect.setType(BasicEffect.BasicEffectType.PERCENT);

        effect.apply(gameState);

        Assert.assertEquals(11, gameState.getAttack().getModifiedValue());

        effect.unapply(gameState);

        Assert.assertEquals(10, gameState.getAttack().getModifiedValue());
    }
}
