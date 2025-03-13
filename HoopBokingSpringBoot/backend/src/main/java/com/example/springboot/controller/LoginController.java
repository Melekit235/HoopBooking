package com.example.springboot.controller;

import com.example.springboot.model.Player;
import com.example.springboot.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final PlayerService playerService;

    public LoginController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String showLoginForm() {
        return "login";  // Страница входа
    }

    @PostMapping
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {
        Player player = playerService.authenticate(email, password);
        if (player != null) {
            return "redirect:/main"; // Перенаправление на главную страницу
        } else {
            model.addAttribute("message", "Неверный email или пароль.");
            return "login"; // Остаемся на странице входа с ошибкой
        }
    }

    @GetMapping("/main")
    public String logout() {
        return "redirect:/main"; // Перенаправление на страницу входа после выхода
    }


    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

}
