package com.example.springboot.controller;

import com.example.springboot.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final PlayerService playerService;

    public ProfileController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String showProfileForm() {
        return "profile";
    }
}
