package com.github.VLmb.java_book_trader.service;

import com.github.VLmb.java_book_trader.dto.RegisterUserDto;
import com.github.VLmb.java_book_trader.entity.User;

public interface AuthService {
    User register(RegisterUserDto registerUserDto);
}