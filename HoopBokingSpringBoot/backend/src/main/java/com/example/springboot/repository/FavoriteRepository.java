package com.example.springboot.repository;

import com.example.springboot.model.Favorite;
import com.example.springboot.model.Player;
import com.example.springboot.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {


    List<Favorite> findByPlayer(Player player);

    List<Favorite> findByCourt(Court court);

}
