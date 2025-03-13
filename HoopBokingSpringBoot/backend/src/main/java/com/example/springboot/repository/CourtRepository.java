package com.example.springboot.repository;

import com.example.springboot.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourtRepository extends JpaRepository<Court, Integer> {

    List<Court> findAll();
}
