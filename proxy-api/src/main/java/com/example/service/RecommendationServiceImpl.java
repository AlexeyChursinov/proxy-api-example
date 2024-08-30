package com.example.service;

import com.example.dto.EventDto;
import com.example.dto.RecommendationEventDto;
import com.example.dto.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final RSocketRequester rSocketRequesterEvent;
    private final RSocketRequester rSocketRequesterUser;

    public RecommendationServiceImpl(
            @Qualifier("eventServiceRequester") RSocketRequester rSocketRequesterEvent,
            @Qualifier("userServiceRequester") RSocketRequester rSocketRequesterUser) {
        this.rSocketRequesterEvent = rSocketRequesterEvent;
        this.rSocketRequesterUser = rSocketRequesterUser;
    }

    @Override
    public Flux<RecommendationEventDto> getRecommendations(Long userId) {
        return rSocketRequesterUser
                .route("getUser")
                .data(userId)
                .retrieveMono(UserDto.class)
                .flatMapMany(userDto -> {
                    String preferredCategories = userDto.getPreferredCategories();

                    List<String> categories = Arrays.stream(preferredCategories.replace("{", "")
                                    .replace("}", "").split(","))
                            .map(String::trim)
                            .collect(Collectors.toList());

                    return rSocketRequesterEvent
                            .route("getEventsByCategories")
                            .data(categories)
                            .retrieveFlux(EventDto.class)
                            .map(eventDto -> {
                                RecommendationEventDto recommendation = new RecommendationEventDto();
                                recommendation.setEventId(eventDto.getId());
                                recommendation.setName(eventDto.getName());
                                recommendation.setDescription(eventDto.getDescription());
                                recommendation.setDate(eventDto.getDate());
                                recommendation.setLocation(eventDto.getLocation());
                                recommendation.setCategory(eventDto.getCategory());
                                recommendation.setRecommendReason("предпочтения пользователя");
                                return recommendation;
                            });
                });
    }

    @Override
    public Flux<EventDto> getEvents() {
        return rSocketRequesterEvent
                .route("getEvents")
                .retrieveFlux(EventDto.class);
    }

    @Override
    public Mono<UserDto> getUser(Long userId) {
        return rSocketRequesterUser
                .route("getUser")
                .data(userId)
                .retrieveMono(UserDto.class);
    }
}
