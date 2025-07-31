package com.github.VLmb.java_book_trader.controller;

import com.github.VLmb.java_book_trader.dto.RegisterUserDto;
import com.github.VLmb.java_book_trader.entity.User;
import com.github.VLmb.java_book_trader.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authService.register(registerUserDto);

        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
}