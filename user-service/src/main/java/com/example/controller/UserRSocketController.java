package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class UserRSocketController {

    private final UserService userService;

    @MessageMapping("getUser")
    public Mono<UserDto> getUser(@Payload Long userId) {
        return Mono.fromCallable(() -> userService.getUser(userId));
    }

}
