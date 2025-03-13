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

    List<PlayerArrival> findByPlayer(Player player);

    List<PlayerArrival> findByCourt(Court court);

    List<PlayerArrival> findByPlayerAndArrivalDate(Player player, LocalDate arrivalDate);

    List<PlayerArrival> findByCourtAndArrivalDateAndStartTimeBetween(Court court, LocalDate arrivalDate, LocalTime startTime, LocalTime endTime);

}
