package com.example.springboot.controller;

import com.example.springboot.dto.*;
import com.example.springboot.service.ReviewService;
import com.example.springboot.service.CourtService;
import com.example.springboot.service.ArrivalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/court")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class CourtDetailsController {

    private final CourtService courtService;
    private final ReviewService reviewService;
    private final ArrivalService arrivalService;

    public CourtDetailsController(CourtService courtService, ReviewService reviewService, ArrivalService arrivalService) {
        this.courtService = courtService;
        this.reviewService = reviewService;
        this.arrivalService = arrivalService;
    }

    @GetMapping("/{courtId}")
    public CourtDto getCourtDetails(@PathVariable Integer courtId) {
        return courtService.getCourtDetailsById(courtId);
    }

    @GetMapping("/{courtId}/arrivals")
    public List<ArrivalResponseDto> getCourtArrivals(@PathVariable Integer courtId) {
        return arrivalService.getPlayerArrivalsByCourtId(courtId);
    }

    @GetMapping("/{courtId}/reviews")
    public List<ReviewResponseDto> getCourtReviews(@PathVariable Integer courtId) {
        return reviewService.getCourtReviewById(courtId);
    }

    @PostMapping("/{courtId}/arrivals")
    public ResponseEntity<String> arrivalCourt(@PathVariable Integer courtId, @RequestBody ArrivalRequestDto arrivalRequestDto) {
        arrivalService.addPlayerArrival(courtId, arrivalRequestDto);
        return ResponseEntity.ok("ok");
    }


    @PostMapping("/{courtId}/reviews")
    public ResponseEntity<String> postReview(@PathVariable Integer courtId, @RequestBody ReviewRequestDto reviewRequest) {
        reviewService.addReview(courtId, reviewRequest);
        return ResponseEntity.ok("ok");
    }


    @PutMapping("/{courtId}")
    public ResponseEntity<String> updateCourt(@PathVariable Integer courtId, @RequestBody CourtRequestDto courtRequestDto) {
        courtService.updateCourt(courtId, courtRequestDto);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{courtId}")
    public ResponseEntity<String> deleteCourt(@PathVariable Integer courtId) {
        courtService.deleteCourt(courtId);
        return ResponseEntity.ok("");
    }

}
