package com.example.springboot.repository;

import com.example.springboot.dto.CourtDto;
import com.example.springboot.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourtRepository extends JpaRepository<Court, Integer> {

    List<Court> findAll();

    @Query("""
            SELECT new com.example.springboot.dto.CourtDto(c.courtId, c.courtAddress, ct.type, ci.cityName)
            FROM Court c
            JOIN c.city ci
            JOIN c.courtType ct
            """
    )
    List<CourtDto> findAllCourtsWithNames();

    @Query("SELECT new com.example.springboot.dto.CourtDto(c.courtId, ci.cityName, ct.type, c.courtAddress) " +
            "FROM Court c " +
            "JOIN c.city ci " +
            "JOIN c.courtType ct " +
            "WHERE c.courtId = :courtId")
    CourtDto findCourtById(@Param("courtId") Integer courtId);


}
