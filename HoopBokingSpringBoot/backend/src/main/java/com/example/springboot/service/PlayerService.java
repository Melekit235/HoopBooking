package com.example.springboot.service;

import com.example.springboot.model.Player;
import com.example.springboot.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Получение всех игроков
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Получение игрока по ID
    public Optional<Player> getPlayerById(Integer playerId) {
        return playerRepository.findById(playerId);
    }


    public Player getPlayerByEmail(String email) {
        return playerRepository.findByEmail(email);
    }




    public boolean register(String firsName, String lastName, String email, String password) {

       /* if (playerRepository.findByEmail(email)) {
            return false;
        }*/


        Player newPlayer = new Player();
        newPlayer.setPlayerId(1);
        newPlayer.setFirstName(firsName);
        newPlayer.setLastName(lastName);
        newPlayer.setEmail(email);
        newPlayer.setPasswordHash(password);

        playerRepository.save(newPlayer);
        return true;
    }




    // Обновление существующего игрока (без изменения пароля)
    public Player updatePlayer(Player player) {
        Optional<Player> existingPlayer = playerRepository.findById(player.getPlayerId());

        if (existingPlayer.isPresent()) {
            Player updatedPlayer = existingPlayer.get();
            updatedPlayer.setFirstName(player.getFirstName());
            updatedPlayer.setLastName(player.getLastName());
            updatedPlayer.setEmail(player.getEmail());

            return playerRepository.save(updatedPlayer);
        }
        return null;
    }

    public Player authenticate(String email, String password) {

        Player playerOptional = playerRepository.findByEmail(email);

        if (Objects.equals(playerOptional.getEmail(), email) && (Objects.equals(playerOptional.getPasswordHash(), password))) {
            return playerOptional;
        }

        return null;
    }


    public void deletePlayer(Integer playerId) {
        playerRepository.deleteById(playerId);
    }


}
