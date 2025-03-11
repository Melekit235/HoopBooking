package org.example.model.dao.impl;

import org.example.model.dao.CityDao;
import org.example.model.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDao {
    private final Connection connection;

    public CityDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCity(City city) {
        String query = "INSERT INTO public.cities (city_id, city_name) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, city.getCityId());
            statement.setString(2, city.getCityName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public City getCity(int cityId) {
        String query = "SELECT * FROM public.cities WHERE city_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cityId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new City(
                        resultSet.getInt("city_id"),
                        resultSet.getString("city_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        String query = "SELECT * FROM public.cities";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                cities.add(new City(
                        resultSet.getInt("city_id"),
                        resultSet.getString("city_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void updateCity(City city) {
        String query = "UPDATE public.cities SET city_name = ? WHERE city_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, city.getCityName());
            statement.setInt(2, city.getCityId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(int cityId) {
        String query = "DELETE FROM public.cities WHERE city_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, cityId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
