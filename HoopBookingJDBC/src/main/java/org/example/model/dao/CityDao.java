package org.example.model.dao;

import org.example.model.entity.City;

import java.util.List;

public interface CityDao {
    void addCity(City city);
    City getCity(int cityId);
    List<City> getAllCities();
    void updateCity(City city);
    void deleteCity(int cityId);
}
