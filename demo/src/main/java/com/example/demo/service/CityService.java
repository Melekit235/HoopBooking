package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(Integer cityId) {
        return cityRepository.findById(cityId);
    }

    public Optional<City> getCityByName(String cityName){return cityRepository.findByCityName(cityName);}

    public List<City> findByName(String cityName) {
        return cityRepository.findByCityNameContainingIgnoreCase(cityName);
    }
}
