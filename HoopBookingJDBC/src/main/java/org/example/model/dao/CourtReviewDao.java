package org.example.model.dao;

import org.example.model.entity.CourtReview;

import java.util.List;

public interface CourtReviewDao {

    void addCourtReview(CourtReview courtReview);
    CourtReview getCourtReview(int reviewId);
    List<CourtReview> getAllReviewsByCourtId(int courtId);
    List<CourtReview> getAllReviewsByPlayerId(int playerId);
    void updateCourtReview(CourtReview courtReview);
    void deleteCourtReview(int reviewId);
}
