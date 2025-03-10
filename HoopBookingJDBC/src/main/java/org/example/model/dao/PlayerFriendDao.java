package org.example.model.dao;

import org.example.model.entity.PlayerFriend;

import java.util.List;

public interface PlayerFriendDao {

    void addPlayerFriend(PlayerFriend playerFriend);
    List<PlayerFriend> getAllFriendsByPlayerId(int playerId);
    void deletePlayerFriend(int playerId, int friendId);
}
