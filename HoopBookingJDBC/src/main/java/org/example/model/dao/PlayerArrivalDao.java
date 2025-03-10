package org.example.model.dao;

import org.example.model.entity.PlayerArrival;

import java.util.List;

public interface PlayerArrivalDao {
    void addPlayerArrival(PlayerArrival playerArrival);
    PlayerArrival getPlayerArrival(int playerId, int courtId);
    List<PlayerArrival> getAllPlayerArrivals();
    void updatePlayerArrival(PlayerArrival playerArrival);
    void deletePlayerArrival(int playerId, int courtId);
}
