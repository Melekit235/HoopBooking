package com.example.springboot.service;

import com.example.springboot.model.City;
import com.example.springboot.repository.CityRepository;
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

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(Integer cityId, City cityDetails) {

        if (cityRepository.existsById(cityId)) {
            cityDetails.setCityId(cityId);
            return cityRepository.save(cityDetails);
        }
        return null;
    }


    public void deleteCity(Integer cityId) {
        cityRepository.deleteById(cityId);
    }
}
