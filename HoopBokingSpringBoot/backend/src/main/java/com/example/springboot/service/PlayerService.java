package com.example.springboot.service;

import com.example.springboot.dto.PlayerDto;
import com.example.springboot.model.Player;
import com.example.springboot.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Optional<Player> getPlayerById(Integer playerId) {
        return playerRepository.findById(playerId);
    }

    public PlayerDto getPlayerDtoById(Integer playerId) {
        return playerRepository.findPlayerById(playerId);
    }

    public void register(PlayerDto playerDto) {

        Player newPlayer = new Player();
        newPlayer.setFirstName(playerDto.getFirstName());
        newPlayer.setLastName(playerDto.getLastName());
        newPlayer.setEmail(playerDto.getEmail());
        newPlayer.setPasswordHash(playerDto.getPasswordHash());

        playerRepository.save(newPlayer);
    }

    public Player authenticate(String email, String password) {

        Player playerOptional = playerRepository.findByEmail(email);

        if (Objects.equals(playerOptional.getEmail(), email) && (Objects.equals(playerOptional.getPasswordHash(), password))) {
            return playerOptional;
        }

        return null;
    }

}
