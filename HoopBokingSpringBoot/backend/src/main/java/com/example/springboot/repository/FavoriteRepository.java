package com.example.springboot.repository;

import com.example.springboot.model.Favorite;
import com.example.springboot.model.Player;
import com.example.springboot.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    // Метод для получения всех фаворитов для определенного игрока
    List<Favorite> findByPlayer(Player player);

    // Метод для получения всех фаворитов для определенной площадки
    List<Favorite> findByCourt(Court court);

    // Можно добавить другие кастомные методы для специфичных запросов
}
