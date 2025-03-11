package org.example.model.dao.impl;

import org.example.model.dao.PlayerDao;
import org.example.model.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {
    private final Connection connection;

    public PlayerDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addPlayer(Player player) {
        String query = "INSERT INTO public.players (player_id, first_name, last_name, email, password_hash) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, player.getPlayerId());
            statement.setString(2, player.getFirstName());
            statement.setString(3, player.getLastName());
            statement.setString(4, player.getEmail());
            statement.setString(5, player.getPasswordHash());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Player getPlayer(int playerId) {
        String query = "SELECT * FROM public.players WHERE player_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password_hash")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM public.players";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                players.add(new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("password_hash")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public void updatePlayer(Player player) {
        String query = "UPDATE public.players SET first_name = ?, last_name = ?, email = ?, password_hash = ? WHERE player_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, player.getFirstName());
            statement.setString(2, player.getLastName());
            statement.setString(3, player.getEmail());
            statement.setString(4, player.getPasswordHash());
            statement.setInt(5, player.getPlayerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlayer(int playerId) {
        String query = "DELETE FROM public.players WHERE player_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

