package com.deadsimple.rpg.controller;

import com.deadsimple.rpg.model.Encounter;
import com.deadsimple.rpg.model.EncounterArea;
import com.deadsimple.rpg.model.GameState;
import com.deadsimple.rpg.model.User;
import com.deadsimple.rpg.model.embedded.Message;
import com.deadsimple.rpg.model.embedded.MessageType;
import com.deadsimple.rpg.repository.EncounterAreaRepository;
import com.deadsimple.rpg.repository.GameStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TurnController {
    @Autowired
    EncounterAreaRepository eaRepo;

    @Autowired
    GameStateRepository gsRepo;

    @RequestMapping("/takeTurn/{encounterArea}")
    @ResponseBody
    public GameState takeTurn(@AuthenticationPrincipal User user, @PathVariable String encounterArea) {
        GameState gs = user.getGameState();
        EncounterArea area = eaRepo.findByGameName(encounterArea);
        gs.clearMessages();

        if (gs.getTurns() - area.getTurnCost() <= 0) {
            gs.addMessage(new Message("You don't have enough turns to adventure here", MessageType.BadNews));
            return gs;
        }

        Encounter encounter = area.selectEncounter();
        gs.setCurrentEncounter(encounter);
        gs.addMessage(new Message(encounter.getOpeningText(), MessageType.GoodNews));
        gs  = encounter.run(gs);

        gs.setTurns(gs.getTurns() - area.getTurnCost());

        gsRepo.save(gs);

        return gs;
    }

    @RequestMapping("/continueTurn")
    @ResponseBody
    public GameState continueTurn(@AuthenticationPrincipal User user) {
        GameState gs = user.getGameState();
        gs.clearMessages();

        GameState newGameState = gs.getCurrentEncounter().processPlayerAction(user.getGameState());
        Encounter currentEncounter = newGameState.getCurrentEncounter();

        if (currentEncounter.isComplete(newGameState)) {
             currentEncounter.complete(newGameState);
        }

        gsRepo.save(newGameState);

        return newGameState;
    }
}
