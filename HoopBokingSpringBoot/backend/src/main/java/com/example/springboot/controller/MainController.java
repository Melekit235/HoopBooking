package com.example.springboot.controller;

import com.example.springboot.dto.CourtDto;
import com.example.springboot.dto.CourtRequestDto;
import com.example.springboot.model.City;
import com.example.springboot.service.CityService;
import com.example.springboot.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courts")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class MainController {

    private final CourtService courtService;

    public MainController(CourtService courtService, CityService cityService){
        this.courtService = courtService;
    }

    @GetMapping
    public List<CourtDto> getAllCourts() {
        List<CourtDto> dfd = courtService.getAllCourts();
        return courtService.getAllCourts();
    }

    @PostMapping
    public ResponseEntity<String> addCourt(@RequestBody CourtRequestDto request) {
        //List<CourtDto> dfd = courtService.getAllCourts();
        courtService.addCourt(request);
        return ResponseEntity.ok("");

    }
}
