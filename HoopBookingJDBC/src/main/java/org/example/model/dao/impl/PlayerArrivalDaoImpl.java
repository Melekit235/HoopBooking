package org.example.model.dao.impl;

import org.example.model.dao.PlayerArrivalDao;
import org.example.model.entity.PlayerArrival;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PlayerArrivalDaoImpl implements PlayerArrivalDao {
    private Connection connection;

    public PlayerArrivalDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addPlayerArrival(PlayerArrival playerArrival) {
        String query = "INSERT INTO public.player_arrivals (player_id, court_id, arrival_date, start_time, end_time) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerArrival.getPlayerId());
            statement.setInt(2, playerArrival.getCourtId());
            statement.setDate(3, java.sql.Date.valueOf(playerArrival.getArrivalDate()));
            statement.setObject(4, playerArrival.getStartTime());
            statement.setObject(5, playerArrival.getEndTime());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PlayerArrival getPlayerArrival(int playerId, int courtId) {
        String query = "SELECT * FROM public.player_arrivals WHERE player_id = ? AND court_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.setInt(2, courtId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Use resultSet.getObject to directly map to LocalTime
                LocalTime startTime = resultSet.getObject("start_time", LocalTime.class);
                LocalTime endTime = resultSet.getObject("end_time", LocalTime.class);
                return new PlayerArrival(
                        resultSet.getInt("player_id"),
                        resultSet.getInt("court_id"),
                        resultSet.getDate("arrival_date").toLocalDate(),
                        startTime,
                        endTime
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<PlayerArrival> getAllPlayerArrivals() {
        List<PlayerArrival> playerArrivals = new ArrayList<>();
        String query = "SELECT * FROM public.player_arrivals";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Use resultSet.getObject to directly map to LocalTime
                LocalTime startTime = resultSet.getObject("start_time", LocalTime.class);
                LocalTime endTime = resultSet.getObject("end_time", LocalTime.class);
                playerArrivals.add(new PlayerArrival(
                        resultSet.getInt("player_id"),
                        resultSet.getInt("court_id"),
                        resultSet.getDate("arrival_date").toLocalDate(),
                        startTime,
                        endTime
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerArrivals;
    }

    @Override
    public void updatePlayerArrival(PlayerArrival playerArrival) {
        String query = "UPDATE public.player_arrivals SET arrival_date = ?, start_time = ?, end_time = ? WHERE player_id = ? AND court_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, java.sql.Date.valueOf(playerArrival.getArrivalDate()));
            statement.setObject(2, playerArrival.getStartTime());
            statement.setObject(3, playerArrival.getEndTime());
            statement.setInt(4, playerArrival.getPlayerId());
            statement.setInt(5, playerArrival.getCourtId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlayerArrival(int playerId, int courtId) {
        String query = "DELETE FROM public.player_arrivals WHERE player_id = ? AND court_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.setInt(2, courtId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
