package com.example.springboot.service;

import com.example.springboot.dto.FavoriteDto;
import com.example.springboot.model.Favorite;
import com.example.springboot.model.Player;
import com.example.springboot.model.Court;
import com.example.springboot.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }


    public List<FavoriteDto> getFavoriteCourtsByPlayerId(Integer playerId) {
        return favoriteRepository.findFavoriteCourtsByPlayerId(playerId);
    }


    public List<Favorite> getFavoritesByPlayer(Player player) {
        return favoriteRepository.findByPlayer(player);
    }

    public List<Favorite> getFavoritesByCourt(Court court) {
        return favoriteRepository.findByCourt(court);
    }

    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }

    public Optional<Favorite> getFavoriteById(Long id) {
        return favoriteRepository.findById(id);
    }
}
