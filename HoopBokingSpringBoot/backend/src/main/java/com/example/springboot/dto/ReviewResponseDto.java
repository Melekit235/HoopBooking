package com.example.springboot.dto;

import java.time.LocalDate;

public class ReviewResponseDto {

    private String reviewText;
    private LocalDate reviewDate;
    private String firstName;
    private String lastName;

    public ReviewResponseDto(String reviewText, LocalDate reviewDate, String firstName, String lastName) {
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
        this.firstName = firstName;
        this.lastName = lastName;
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


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
