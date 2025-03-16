package com.example.springboot.controller;

import com.example.springboot.dto.FavoriteDto;
import com.example.springboot.dto.FriendDto;
import com.example.springboot.dto.PlayerDto;
import com.example.springboot.service.FavoriteService;
import com.example.springboot.service.FriendService;
import com.example.springboot.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class ProfileController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private FriendService friendService;

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping
    @RequestMapping("/{userId}")
    public PlayerDto showProfileForm(@PathVariable Integer userId) {
        return playerService.getPlayerDtoById(userId);
    }

    @GetMapping
    @RequestMapping("/friends/{userId}")
    public List<FriendDto> showPlayerFiend(@PathVariable Integer userId) {
        return friendService.getFriendById(userId);
    }

    @GetMapping
    @RequestMapping("/favorites/{userId}")
    public List<FavoriteDto> showFavorite(@PathVariable Integer userId) {
        return favoriteService.getFavoriteCourtsByPlayerId(userId);
    }
}
