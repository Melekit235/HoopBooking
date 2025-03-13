package com.example.springboot.controller;

import com.example.springboot.model.Player;
import com.example.springboot.service.PlayerService;
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
	public String showRegisterForm() {
		return "register";
	}

	@PostMapping
	public String registerPlayer(@RequestParam String firstName,
								 @RequestParam String lastName,
								 @RequestParam String email,
								 @RequestParam String password,
								 Model model) {

		playerService.register(firstName, lastName, email, password);
		return "redirect:/login";
	}
}
