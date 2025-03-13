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

    // Метод для получения всех обзоров
    public List<CourtReview> getAllReviews() {
        return courtReviewRepository.findAll();
    }

    // Метод для получения обзора по ID
    public Optional<CourtReview> getReviewById(Integer reviewId) {
        return courtReviewRepository.findById(reviewId);
    }

    // Метод для добавления нового обзора
    public CourtReview addReview(CourtReview courtReview) {
        return courtReviewRepository.save(courtReview);
    }

    // Метод для обновления обзора
    public CourtReview updateReview(Integer reviewId, CourtReview reviewDetails) {
        // Проверяем, существует ли обзор с таким ID
        if (courtReviewRepository.existsById(reviewId)) {
            reviewDetails.setReviewId(reviewId);  // Устанавливаем ID для обновления
            return courtReviewRepository.save(reviewDetails);
        }
        return null;  // Или выбросить исключение, если обзор не найден
    }

    // Метод для удаления обзора по ID
    public void deleteReview(Integer reviewId) {
        courtReviewRepository.deleteById(reviewId);
    }
}
