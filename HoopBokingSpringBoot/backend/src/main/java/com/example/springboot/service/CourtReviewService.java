package com.example.springboot.service;

import com.example.springboot.model.CourtReview;
import com.example.springboot.repository.CourtReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourtReviewService {

    private final CourtReviewRepository courtReviewRepository;

    @Autowired
    public CourtReviewService(CourtReviewRepository courtReviewRepository) {
        this.courtReviewRepository = courtReviewRepository;
    }

    public List<CourtReview> getAllReviews() {
        return courtReviewRepository.findAll();
    }

    public Optional<CourtReview> getReviewById(Integer reviewId) {
        return courtReviewRepository.findById(reviewId);
    }

    public CourtReview addReview(CourtReview courtReview) {
        return courtReviewRepository.save(courtReview);
    }


    public CourtReview updateReview(Integer reviewId, CourtReview reviewDetails) {

        if (courtReviewRepository.existsById(reviewId)) {
            reviewDetails.setReviewId(reviewId);
            return courtReviewRepository.save(reviewDetails);
        }
        return null;
    }

    public void deleteReview(Integer reviewId) {
        courtReviewRepository.deleteById(reviewId);
    }
}
