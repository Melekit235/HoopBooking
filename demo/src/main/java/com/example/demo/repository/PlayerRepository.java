package com.example.demo.repository;

import com.example.demo.dto.PlayerDto;
import com.example.demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findByEmail(String email);

    @Query("""
            SELECT new com.example.demo.dto.PlayerDto(p.firstName, p.lastName, p.email, p.passwordHash)
            FROM Player p
            WHERE p.playerId = :playerId
            """
    )
    PlayerDto findPlayerById(@Param("playerId") Integer playerId);

}
