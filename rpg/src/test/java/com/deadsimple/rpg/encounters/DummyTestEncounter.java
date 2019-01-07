package com.deadsimple.rpg.encounters;

import com.deadsimple.rpg.model.Encounter;
import com.deadsimple.rpg.model.GameState;

public class DummyTestEncounter extends Encounter {

    @Override
    public GameState run(GameState gs) {
        return gs;
    }

    @Override
    public GameState nextStage(GameState gs) {
        return null;
    }

    @Override
    public GameState processPlayerAction(GameState gs) {
        return gs;
    }
}
