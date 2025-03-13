package com.example.springboot.service;

import com.example.springboot.model.PlayerArrival;
import com.example.springboot.model.Player;
import com.example.springboot.model.Court;
import com.example.springboot.repository.PlayerArrivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerArrivalService {

    private final PlayerArrivalRepository playerArrivalRepository;

    @Autowired
    public PlayerArrivalService(PlayerArrivalRepository playerArrivalRepository) {
        this.playerArrivalRepository = playerArrivalRepository;
    }

    public List<PlayerArrival> getArrivalsByPlayer(Player player) {
        return playerArrivalRepository.findByPlayer(player);
    }

    public List<PlayerArrival> getArrivalsByCourt(Court court) {
        return playerArrivalRepository.findByCourt(court);
    }

    public List<PlayerArrival> getArrivalsByPlayerAndDate(Player player, LocalDate arrivalDate) {
        return playerArrivalRepository.findByPlayerAndArrivalDate(player, arrivalDate);
    }

    public List<PlayerArrival> getArrivalsByCourtAndTime(Court court, LocalDate arrivalDate, LocalTime startTime, LocalTime endTime) {
        return playerArrivalRepository.findByCourtAndArrivalDateAndStartTimeBetween(court, arrivalDate, startTime, endTime);
    }

    public PlayerArrival addPlayerArrival(PlayerArrival playerArrival) {
        return playerArrivalRepository.save(playerArrival);
    }

    public void deletePlayerArrival(Long id) {
        playerArrivalRepository.deleteById(id);
    }

    public Optional<PlayerArrival> getPlayerArrivalById(Long id) {
        return playerArrivalRepository.findById(id);
    }
}
