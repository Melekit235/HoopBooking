package com.example.springboot.controller;

import com.example.springboot.dto.PlayerDto;
import com.example.springboot.model.Player;
import com.example.springboot.service.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class LoginController {

    private final PlayerService playerService;

    public LoginController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Integer loginUser(@RequestBody PlayerDto request) {
        Player player = playerService.authenticate(request.getEmail(), request.getPasswordHash());

        if (player != null) {
            return player.getPlayerId();
        } else {
            return null;
        }
    }
}
