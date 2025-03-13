package com.example.springboot.repository;

import com.example.springboot.model.PlayerArrival;
import com.example.springboot.model.Player;
import com.example.springboot.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface PlayerArrivalRepository extends JpaRepository<PlayerArrival, Long> {

    // Метод для получения всех записей о прибытиях для определенного игрока
    List<PlayerArrival> findByPlayer(Player player);

    // Метод для получения всех записей о прибытиях для определенной площадки
    List<PlayerArrival> findByCourt(Court court);

    // Метод для получения записей о прибытиях для игрока на определенную дату
    List<PlayerArrival> findByPlayerAndArrivalDate(Player player, LocalDate arrivalDate);

    // Метод для получения записей о прибытиях на площадку в определенный период времени
    List<PlayerArrival> findByCourtAndArrivalDateAndStartTimeBetween(Court court, LocalDate arrivalDate, LocalTime startTime, LocalTime endTime);

    // Можно добавлять дополнительные методы для специфичных запросов
}
