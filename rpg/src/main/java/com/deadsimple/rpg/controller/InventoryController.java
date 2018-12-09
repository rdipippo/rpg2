package com.deadsimple.rpg.controller;

import com.deadsimple.rpg.model.GameState;
import com.deadsimple.rpg.model.Item;
import com.deadsimple.rpg.model.User;
import com.deadsimple.rpg.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InventoryController {
    @Autowired
    ItemRepository repo;

    @RequestMapping("/equip/{itemName}")
    public GameState equip(@AuthenticationPrincipal User user, @PathVariable String itemName) {
        GameState gs = user.getGameState();
        Item item = repo.findByGameName(itemName);

        gs = item.onEquip(gs);

        return gs;
    }

    @RequestMapping("/unequip/{itemName}")
    public GameState unequip(@AuthenticationPrincipal User user, @PathVariable String itemName) {
        GameState gs = user.getGameState();
        Item item = repo.findByGameName(itemName);

        gs = item.onUnequip(gs);

        return gs;
    }
}
