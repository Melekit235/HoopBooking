package org.example.model.dao.impl;

import org.example.model.dao.FavoriteDao;
import org.example.model.entity.Favorite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDaoImpl implements FavoriteDao {
    private final Connection connection;

    public FavoriteDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addFavorite(Favorite favorite) {
        String query = "INSERT INTO public.favorites (player_id, court_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, favorite.getPlayerId());
            statement.setInt(2, favorite.getCourtId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Favorite> getFavoritesByPlayerId(int playerId) {
        List<Favorite> favorites = new ArrayList<>();
        String query = "SELECT * FROM public.favorites WHERE player_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                favorites.add(new Favorite(
                        resultSet.getInt("player_id"),
                        resultSet.getInt("court_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favorites;
    }

    @Override
    public List<Favorite> getFavoritesByCourtId(int courtId) {
        List<Favorite> favorites = new ArrayList<>();
        String query = "SELECT * FROM public.favorites WHERE court_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, courtId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                favorites.add(new Favorite(
                        resultSet.getInt("player_id"),
                        resultSet.getInt("court_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favorites;
    }

    @Override
    public void deleteFavorite(int playerId, int courtId) {
        String query = "DELETE FROM public.favorites WHERE player_id = ? AND court_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            statement.setInt(2, courtId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
