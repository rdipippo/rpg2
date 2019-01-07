package com.deadsimple.rpg.model;

import com.deadsimple.rpg.model.embedded.Message;
import com.deadsimple.rpg.model.embedded.MessageType;
import com.deadsimple.rpg.util.RandomRange;

public class CombatEncounter extends Encounter {
    Opponent opponent;
    
    public Opponent getOpponent() {
        return opponent;
    }

    public void setOpponent(Opponent opponent) {
        this.opponent = opponent;
    }

    @Override
    public String getOpeningText() {
        return "You are fighting a " + getOpponent().getName() + ".";
    }

    @Override
    public GameState run(GameState gs) {
        boolean playerHasInitiative = determineInitiative();

        if (playerHasInitiative) {
            gs.addMessage(new Message("You get the jump on it!", MessageType.GoodNews));
        } else {
            gs.addMessage(new Message("It gets the jump on you!", MessageType.GoodNews));
        }

        return gs;
    }

    @Override
    public GameState nextStage(GameState gs) {
        return null;
    }

    private boolean determineInitiative() {
        return RandomRange.trueOrFalse();
    }

    private void attack(Combatant defender, Combatant attacker) {

    }

    @Override
    public GameState processPlayerAction(GameState gs) {
        return null;
    }
}
