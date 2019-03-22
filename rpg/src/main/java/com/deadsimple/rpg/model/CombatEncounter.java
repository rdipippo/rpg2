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
            attack(opponent, gs);
        } else {
            gs.addMessage(new Message("It gets the jump on you!", MessageType.GoodNews));
            attack(gs, opponent);
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
        float attack = Float.valueOf(attacker.getAttack().getModifiedValue());
        float defense = Float.valueOf(defender.getDefense().getModifiedValue());

        float attackRoll = Float.valueOf(RandomRange.generate(1, 100));

        System.out.println("Attack roll:" + attackRoll);
        // TODO should defense add to attack roll? since we are trying to roll low...
        System.out.println("Attack roll after defense:" + (attackRoll - defense + attack));

        if (attackRoll - defense + attack > defense) {
            int damage = attacker.getWeaponDamage().generate();
            defender.getHealth().subtract(damage);

            if (defender instanceof GameState) {
                ((GameState) defender).addMessage(new Message("You took " + damage + " damage.", MessageType.BadNews));
            } else {
                ((GameState) attacker).addMessage(new Message("Your opponent took " + damage + " damage.", MessageType.GoodNews));
            }
        } else {
            if (defender instanceof GameState) {
                ((GameState) defender).addMessage(new Message("Your opponent missed.", MessageType.BadNews));
            } else {
                ((GameState) attacker).addMessage(new Message("You missed.", MessageType.GoodNews));
            }
        }
    }

    @Override
    public GameState processPlayerAction(GameState gs) {
        PlayerAction currentAction = gs.getCurrentAction();

        if (currentAction.getName().equals("Attack")) {
            attack(opponent, gs);
            attack(gs, opponent);
        }

        return gs;
    }

    @Override
    public GameState complete(GameState gs) {
        if (opponent.getHealth().getModifiedValue() == 0) {
            gs.addMessage(new Message("You won!", MessageType.GoodNews));
        } else if (gs.getHealth().getModifiedValue() == 0) {
            gs.addMessage(new Message("You lost!", MessageType.BadNews));
        }

        return gs;
    }

    @Override
    public boolean isComplete(GameState gs) {
        boolean combatOver = false;

        if (opponent.getHealth().getModifiedValue() == 0 || gs.getHealth().getModifiedValue() == 0) {
            combatOver = true;
        }

        return combatOver;
    }
}
