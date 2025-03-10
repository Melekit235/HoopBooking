package org.example.model.dao;

import org.example.model.entity.Favorite;

import java.util.List;

public interface FavoriteDao {
    void addFavorite(Favorite favorite);
    List<Favorite> getFavoritesByPlayerId(int playerId);
    List<Favorite> getFavoritesByCourtId(int courtId);
    void deleteFavorite(int playerId, int courtId);
}
