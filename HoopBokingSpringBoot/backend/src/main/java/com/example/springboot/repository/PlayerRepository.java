package com.example.springboot.repository;

import com.example.springboot.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findByEmail(String email);
}
