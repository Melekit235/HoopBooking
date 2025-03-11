package org.example.model.dao.impl;

import org.example.model.dao.CourtTypeDao;
import org.example.model.entity.CourtType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourtTypeDaoImpl implements CourtTypeDao {
    private final Connection connection;

    public CourtTypeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCourtType(CourtType courtType) {
        String query = "INSERT INTO public.court_types (type_id, type) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, courtType.getTypeId());
            statement.setString(2, courtType.getType());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CourtType getCourtType(int typeId) {
        String query = "SELECT * FROM public.court_types WHERE type_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, typeId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new CourtType(
                        resultSet.getInt("type_id"),
                        resultSet.getString("type")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CourtType> getAllCourtTypes() {
        List<CourtType> courtTypes = new ArrayList<>();
        String query = "SELECT * FROM public.court_types";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                courtTypes.add(new CourtType(
                        resultSet.getInt("type_id"),
                        resultSet.getString("type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courtTypes;
    }

    @Override
    public void updateCourtType(CourtType courtType) {
        String query = "UPDATE public.court_types SET type = ? WHERE type_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courtType.getType());
            statement.setInt(2, courtType.getTypeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourtType(int typeId) {
        String query = "DELETE FROM public.court_types WHERE type_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, typeId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
