package com.example.controller;

import com.example.dto.EventDto;
import com.example.dto.RecommendationEventDto;
import com.example.dto.UserDto;
import com.example.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final RecommendationService recommendationService;

    @GetMapping("/recommendations/{userId}")
    public Flux<RecommendationEventDto> getRecommendation(@PathVariable Long userId) {
        return recommendationService.getRecommendations(userId);
    }

    // For testing RSocket
    @GetMapping("/events")
    public Flux<EventDto> getEvents() {
        return recommendationService.getEvents();
    }

    // For testing RSocket
    @GetMapping("/{userId}")
    public Mono<UserDto> getUser(@PathVariable Long userId) {
        return recommendationService.getUser(userId);
    }

}
