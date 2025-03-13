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

    // Получение всех записей о прибытиях для определенного игрока
    public List<PlayerArrival> getArrivalsByPlayer(Player player) {
        return playerArrivalRepository.findByPlayer(player);
    }

    // Получение всех записей о прибытиях для определенной площадки
    public List<PlayerArrival> getArrivalsByCourt(Court court) {
        return playerArrivalRepository.findByCourt(court);
    }

    // Получение записей о прибытиях для игрока на определенную дату
    public List<PlayerArrival> getArrivalsByPlayerAndDate(Player player, LocalDate arrivalDate) {
        return playerArrivalRepository.findByPlayerAndArrivalDate(player, arrivalDate);
    }

    // Получение записей о прибытиях на площадку в определенный период времени
    public List<PlayerArrival> getArrivalsByCourtAndTime(Court court, LocalDate arrivalDate, LocalTime startTime, LocalTime endTime) {
        return playerArrivalRepository.findByCourtAndArrivalDateAndStartTimeBetween(court, arrivalDate, startTime, endTime);
    }

    // Добавление новой записи о прибытии
    public PlayerArrival addPlayerArrival(PlayerArrival playerArrival) {
        return playerArrivalRepository.save(playerArrival);
    }

    // Удаление записи о прибытии по ID
    public void deletePlayerArrival(Long id) {
        playerArrivalRepository.deleteById(id);
    }

    // Получение записи о прибытии по ID
    public Optional<PlayerArrival> getPlayerArrivalById(Long id) {
        return playerArrivalRepository.findById(id);
    }
}
