package com.example.springboot.repository;

import com.example.springboot.dto.FavoriteDto;
import com.example.springboot.model.Favorite;
import com.example.springboot.model.Player;
import com.example.springboot.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {


    List<Favorite> findByPlayer(Player player);

    List<Favorite> findByCourt(Court court);

    @Query("""
            
            SELECT new com.example.springboot.dto.FavoriteDto(c.courtId, ci.cityName, ct.type, c.courtAddress)
            FROM Favorite f
            JOIN f.court c
            JOIN c.city ci
            JOIN c.courtType ct
            WHERE f.player.playerId = :playerId
            """
    )
    List<FavoriteDto> findFavoriteCourtsByPlayerId(@Param("playerId") Integer playerId);


}
