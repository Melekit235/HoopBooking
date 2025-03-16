package com.example.springboot.controller;

import com.example.springboot.dto.CourtDto;
import com.example.springboot.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courts")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class MainController {

    @Autowired
    private CourtService courtService;

    @GetMapping
    public List<CourtDto> getAllCourts() {
        List<CourtDto> dfd = courtService.getAllCourts();
        return courtService.getAllCourts();
    }
}
