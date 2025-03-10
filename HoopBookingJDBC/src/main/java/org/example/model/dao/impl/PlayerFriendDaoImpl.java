package org.example.model.dao.impl;

import org.example.model.dao.PlayerFriendDao;
import org.example.model.entity.PlayerFriend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerFriendDaoImpl implements PlayerFriendDao {
    private Connection connection;

    public PlayerFriendDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addPlayerFriend(PlayerFriend playerFriend) {
        String query = "INSERT INTO public.player_friends (player_id, friend_id, friendship_date) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerFriend.getPlayerId());
            statement.setInt(2, playerFriend.getFriendId());
            statement.setDate(3, java.sql.Date.valueOf(playerFriend.getFriendshipDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PlayerFriend> getAllFriendsByPlayerId(int playerId) {
        List<PlayerFriend> playerFriends = new ArrayList<>();
        String query = "SELECT * FROM public.player_friends WHERE player_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                playerFriends.add(new PlayerFriend(
                        resultSet.getInt("player_id"),
                        resultSet.getInt("friend_id"),
                        resultSet.getDate("friendship_date").toLocalDate()  // Преобразуем java.sql.Date в LocalDate
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerFriends;
    }


    @Override
    public void deletePlayerFriend(int playerId, int friendId) {
        String query = "DELETE FROM public.player_friends WHERE player_id = ? AND friend_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.setInt(2, friendId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
