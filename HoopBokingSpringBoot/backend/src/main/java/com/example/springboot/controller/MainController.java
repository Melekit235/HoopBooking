package com.example.springboot.controller;

import com.example.springboot.model.Court;
import com.example.springboot.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private CourtService courtService;

    @GetMapping
    public String showAllCourts(Model model) {
        List<Court> courts = courtService.getAllCourts();
        model.addAttribute("courts", courts);
        return "main";
    }
}
