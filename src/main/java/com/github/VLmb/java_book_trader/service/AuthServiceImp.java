package com.github.VLmb.java_book_trader.service;

import com.github.VLmb.java_book_trader.dto.RegisterUserDto;
import com.github.VLmb.java_book_trader.entity.User;
import com.github.VLmb.java_book_trader.repository.UserRepository;
import com.github.VLmb.java_book_trader.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(RegisterUserDto registerUserDto) {
        if (userRepository.findByUsername(registerUserDto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Пользователь с таким username уже существует");
        }
        if (userRepository.findByEmail(registerUserDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Пользователь с таким email уже существует");
        }

        User newUser = new User();
        newUser.setUsername(registerUserDto.getUsername());
        newUser.setPassword(registerUserDto.getPassword());
        newUser.setEmail(registerUserDto.getEmail());
        newUser.setCity(registerUserDto.getCity());

        return userRepository.save(newUser);
    }

}
