package com.example.service;

import com.example.dto.UserDto;

import java.util.Optional;

public interface UserService {

    UserDto getUser(Long userId);

}
