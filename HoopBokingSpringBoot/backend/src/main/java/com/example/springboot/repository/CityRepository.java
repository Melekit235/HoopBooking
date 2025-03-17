package com.example.springboot.repository;

import com.example.springboot.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    Optional<City> findByCityName(String cityName);

    List<City> findByCityNameContainingIgnoreCase(String cityName);
}
