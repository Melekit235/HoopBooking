package com.example.demo.controller;

import com.example.demo.dto.PlayerDto;
import com.example.demo.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private final PlayerService playerService;

	public RegisterController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@GetMapping
	public String showRegisterForm(Model model) {
		return "register";
	}

	@PostMapping
	public String registerPlayer(@ModelAttribute PlayerDto request, Model model) {

		playerService.register(request);
		return "redirect:/login";
	}
}
