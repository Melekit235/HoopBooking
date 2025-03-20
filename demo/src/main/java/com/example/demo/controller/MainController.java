package com.example.demo.controller;

import com.example.demo.dto.CourtDto;
import com.example.demo.dto.CourtRequestDto;
import com.example.demo.model.Court;
import com.example.demo.service.CityService;
import com.example.demo.service.CourtService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/courts")
public class MainController {

    private final CourtService courtService;

    public MainController(CourtService courtService, CityService cityService){
        this.courtService = courtService;
    }

    @GetMapping
    public String getAllCourts(Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("courts", courtService.getAllCourts());
        return "main";
    }

    @PostMapping
    public String addCourt(@ModelAttribute CourtRequestDto request) {
        courtService.addCourt(request);
        return "redirect:/courts";
    }

}
