package com.example.springboot.service;

import com.example.springboot.dto.ReviewResponseDto;
import com.example.springboot.dto.ReviewRequestDto;
import com.example.springboot.model.Court;
import com.example.springboot.model.Player;
import com.example.springboot.model.Review;
import com.example.springboot.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final CourtService courtService;
    private final PlayerService playerService;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, CourtService courtService, PlayerService playerService) {
        this.reviewRepository = reviewRepository;
        this.courtService = courtService;
        this.playerService = playerService;
    }

    public List<ReviewResponseDto> getCourtReviewById(Integer courtId) {
        return reviewRepository.findAllReviewsByCourtId(courtId);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Integer reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public void addReview(Integer courtId, ReviewRequestDto reviewRequestDto) {
        Review review = new Review();

        Player player = playerService.getPlayerById(reviewRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Player not found"));
        Court court = courtService.getCourtById(courtId)
                .orElseThrow(() -> new RuntimeException("Court not found"));

        review.setCourt(court);
        review.setPlayer(player);
        review.setReviewText(reviewRequestDto.getText());
        review.setReviewDate(LocalDate.now());
        reviewRepository.save(review);
    }
}
