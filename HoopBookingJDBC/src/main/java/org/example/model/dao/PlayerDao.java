package org.example.model.dao;

import org.example.model.entity.Player;

import java.util.List;

public interface PlayerDao {

    void addPlayer(Player player);
    Player getPlayer(int playerId);
    List<Player> getAllPlayers();
    void updatePlayer(Player player);
    void deletePlayer(int playerId);

}
