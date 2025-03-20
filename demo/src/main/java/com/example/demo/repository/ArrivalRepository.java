package com.example.demo.repository;

import com.example.demo.dto.ArrivalResponseDto;
import com.example.demo.model.Arrival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArrivalRepository extends JpaRepository<Arrival, Long> {

    @Query("""
            SELECT new com.example.demo.dto.ArrivalResponseDto
            (
            pa.player.firstName || ' ' || pa.player.lastName, pa.arrivalDate, pa.startTime, pa.endTime)
            FROM Arrival pa
            WHERE pa.court.courtId = :courtId
        """
    )
    List<ArrivalResponseDto> findPlayerArrivalsByCourtId(@Param("courtId") Integer courtId);
}
