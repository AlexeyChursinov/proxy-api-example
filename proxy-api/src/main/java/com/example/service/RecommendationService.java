package com.example.service;

import com.example.dto.EventDto;
import com.example.dto.RecommendationEventDto;
import com.example.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecommendationService {

    Flux<RecommendationEventDto> getRecommendations(Long userId);

    Flux<EventDto> getEvents();

    Mono<UserDto> getUser(Long userId);

}
