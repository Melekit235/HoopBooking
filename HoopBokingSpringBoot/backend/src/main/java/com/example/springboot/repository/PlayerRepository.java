package com.example.springboot.repository;

import com.example.springboot.dto.PlayerDto;
import com.example.springboot.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findByEmail(String email);

    @Query("SELECT new com.example.springboot.dto.PlayerDto(p.firstName, p.lastName, p.email, p.passwordHash) " +
            "FROM Player p " +
            "WHERE p.playerId = :playerId")
    PlayerDto findPlayerById(@Param("playerId") Integer playerId);

}
