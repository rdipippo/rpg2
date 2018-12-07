package com.deadsimple.rpg.controller;

import com.deadsimple.rpg.model.GameState;
import com.deadsimple.rpg.model.User;
import com.deadsimple.rpg.repository.GameStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MainPageController {
    @Autowired
    GameStateRepository repo;

    @RequestMapping("/")
    @ResponseBody
    public GameState mainPage(Principal principal) {
        User token = (User)((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return token.getGameState();
    }
}
