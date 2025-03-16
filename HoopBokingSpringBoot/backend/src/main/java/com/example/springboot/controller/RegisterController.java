package com.example.springboot.controller;

import com.example.springboot.dto.PlayerDto;
import com.example.springboot.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class RegisterController {

	private final PlayerService playerService;

	public RegisterController(PlayerService playerService) {
		this.playerService = playerService;
	}

	@PostMapping
	public String registerPlayer(@RequestBody PlayerDto request) {
		playerService.register(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPasswordHash());
		return "redirect:/login";
	}
}
