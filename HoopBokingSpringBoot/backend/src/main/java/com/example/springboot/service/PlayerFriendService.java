package com.example.springboot.service;

import com.example.springboot.model.PlayerFriend;
import com.example.springboot.model.Player;
import com.example.springboot.repository.PlayerFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerFriendService {

    private final PlayerFriendRepository playerFriendRepository;

    @Autowired
    public PlayerFriendService(PlayerFriendRepository playerFriendRepository) {
        this.playerFriendRepository = playerFriendRepository;
    }

    public List<PlayerFriend> getFriendsByPlayer(Player player) {
        return playerFriendRepository.findByPlayer(player);
    }

    public PlayerFriend addPlayerFriend(PlayerFriend playerFriend) {
        return playerFriendRepository.save(playerFriend);
    }

    public void deletePlayerFriend(Long id) {
        playerFriendRepository.deleteById(id);
    }

    public Optional<PlayerFriend> getPlayerFriendById(Long id) {
        return playerFriendRepository.findById(id);
    }
}
