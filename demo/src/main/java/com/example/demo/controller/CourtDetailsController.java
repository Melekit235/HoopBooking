package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.ReviewService;
import com.example.demo.service.CourtService;
import com.example.demo.service.ArrivalService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/court")
public class CourtDetailsController {

    private final CourtService courtService;
    private final ReviewService reviewService;
    private final ArrivalService arrivalService;

    public CourtDetailsController(CourtService courtService, ReviewService reviewService, ArrivalService arrivalService) {
        this.courtService = courtService;
        this.reviewService = reviewService;
        this.arrivalService = arrivalService;
    }

    @GetMapping
    public String getCourtDetails(@RequestParam("id") Integer courtId, Model model) {
        CourtDto court = courtService.getCourtDetailsById(courtId);
        List<ArrivalResponseDto> arrivals = arrivalService.getPlayerArrivalsByCourtId(courtId);
        List<ReviewResponseDto> reviews = reviewService.getCourtReviewById(courtId);

        model.addAttribute("court", court);
        model.addAttribute("arrivals", arrivals);
        model.addAttribute("reviews", reviews);

        return "courtDetails";
    }



    @PostMapping("/arrivals")
    public String arrivalCourt(@RequestParam("courtId") Integer courtId, @ModelAttribute ArrivalRequestDto arrivalRequestDto, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        arrivalRequestDto.setUserId(userId);
        arrivalService.addPlayerArrival(courtId, arrivalRequestDto);
        return "redirect:/court?id=" + courtId;
    }

    @PostMapping("/reviews")
    public String postReview(@RequestParam("courtId") Integer courtId, @ModelAttribute ReviewRequestDto reviewRequest, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        reviewRequest.setUserId(userId);
        reviewService.addReview(courtId, reviewRequest);
        return "redirect:/court?id=" + courtId;
    }

    @PutMapping("/{courtId}")
    public String updateCourt(@PathVariable Integer courtId, @ModelAttribute CourtRequestDto courtRequestDto) {
        courtService.updateCourt(courtId, courtRequestDto);
        return "redirect:/court?id=" + courtId;
    }

    @DeleteMapping("/{courtId}")
    public String deleteCourt(@PathVariable Integer courtId) {
        courtService.deleteCourt(courtId);
        return "redirect:/courts";
    }
}
