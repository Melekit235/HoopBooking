package com.example.springboot.repository;

import com.example.springboot.model.CourtType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtTypeRepository extends JpaRepository<CourtType, Integer> {
}
