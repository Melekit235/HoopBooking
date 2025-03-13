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

    // Метод для получения всех городов
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Метод для получения города по ID
    public Optional<City> getCityById(Integer cityId) {
        return cityRepository.findById(cityId);
    }

    // Метод для добавления нового города
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    // Метод для обновления информации о городе
    public City updateCity(Integer cityId, City cityDetails) {
        // Проверяем, существует ли город с таким ID
        if (cityRepository.existsById(cityId)) {
            cityDetails.setCityId(cityId);  // Устанавливаем ID для обновления
            return cityRepository.save(cityDetails);
        }
        return null;  // Или выбросить исключение, если город не найден
    }

    // Метод для удаления города по ID
    public void deleteCity(Integer cityId) {
        cityRepository.deleteById(cityId);
    }
}
