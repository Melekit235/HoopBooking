package org.example.model.entity;

import java.time.LocalDate;

public class CourtReview {

    private int reviewId;
    private int courtId;
    private int playerId;
    private int rating;
    private String reviewText;
    private LocalDate reviewDate;

    public CourtReview(int reviewId, int courtId, int playerId, int rating, String reviewText, LocalDate reviewDate){
        this.reviewId = reviewId;
        this.courtId = courtId;
        this.playerId = playerId;
        this.rating = rating;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Отзыв{id=" + reviewId + ", courtId=" + courtId + ", playerId=" + playerId +
                ", рейтинг=" + rating + ", отзыв='" + reviewText + "', дата_отзыва=" + reviewDate + "}";
    }

}
