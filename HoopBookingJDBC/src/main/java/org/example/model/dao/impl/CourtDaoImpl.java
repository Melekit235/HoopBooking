package org.example.model.dao.impl;

import org.example.model.dao.CourtDao;
import org.example.model.entity.Court;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourtDaoImpl implements CourtDao {
    private Connection connection;

    public CourtDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCourt(Court court) {
        String query = "INSERT INTO public.courts (court_id, city_id, court_type, court_address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, court.getCourtId());
            statement.setInt(2, court.getCityId());
            statement.setInt(3, court.getCourtTypeId());
            statement.setString(4, court.getCourtAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Court getCourt(int courtId) {
        String query = "SELECT * FROM public.courts WHERE court_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, courtId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Court(
                        resultSet.getInt("court_id"),
                        resultSet.getInt("city_id"),
                        resultSet.getInt("court_type"),
                        resultSet.getString("court_address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Court> getAllCourts() {
        List<Court> courts = new ArrayList<>();
        String query = "SELECT * FROM public.courts";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                courts.add(new Court(
                        resultSet.getInt("court_id"),
                        resultSet.getInt("city_id"),
                        resultSet.getInt("court_type"),
                        resultSet.getString("court_address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courts;
    }

    @Override
    public void updateCourt(Court court) {
        String query = "UPDATE public.courts SET city_id = ?, court_type = ?, court_address = ? WHERE court_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, court.getCityId());
            statement.setInt(2, court.getCourtTypeId());
            statement.setString(3, court.getCourtAddress());
            statement.setInt(4, court.getCourtId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourt(int courtId) {
        String query = "DELETE FROM public.courts WHERE court_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, courtId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
