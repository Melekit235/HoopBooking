package com.example.springboot.repository;

import com.example.springboot.dto.ReviewResponseDto;
import com.example.springboot.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query("""
            SELECT new com.example.springboot.dto.ReviewResponseDto(cr.reviewText, cr.reviewDate, p.firstName, p.lastName)
            FROM Review cr
            JOIN cr.player p
            WHERE cr.court.courtId = :courtId
            """
    )
    List<ReviewResponseDto> findAllReviewsByCourtId(@Param("courtId") Integer courtId);
}
