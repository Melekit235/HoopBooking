package com.example.springboot.controller;

import com.example.springboot.service.CourtService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courtdetails")
public class CourtDetailsController {

    private final CourtService courtService;

    public CourtDetailsController(CourtService courtService) {
        this.courtService = courtService;
    }

    @GetMapping
    public String showCourtDetailsForm() {
        return "courtDetails";
    }
}
