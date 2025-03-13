package com.example.springboot.repository;

import com.example.springboot.model.CourtReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtReviewRepository extends JpaRepository<CourtReview, Integer> {
}
