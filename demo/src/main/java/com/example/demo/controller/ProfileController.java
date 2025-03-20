package com.example.demo.controller;

import com.example.demo.service.FavoriteService;
import com.example.demo.service.FriendService;
import com.example.demo.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final PlayerService playerService;

    private final FriendService friendService;

    private final FavoriteService favoriteService;

    public ProfileController(PlayerService playerService, FriendService friendService, FavoriteService favoriteService)
    {
        this.playerService = playerService;
        this.friendService = friendService;
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public String showProfileForm(@RequestParam("id") Integer playerId, Model model) {

        model.addAttribute("player", playerService.getPlayerDtoById(playerId));
        model.addAttribute("friend", friendService.getFriendById(playerId));
        model.addAttribute("favorite", favoriteService.getFavoriteCourtsByPlayerId(playerId));
        return "profile";
    }
}
