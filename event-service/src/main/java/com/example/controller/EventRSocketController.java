package com.example.controller;

import com.example.dto.EventDto;
import com.example.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventRSocketController {

    private final EventService eventService;

    @MessageMapping("getEvents")
    public Flux<EventDto> getEvents() {
        return Flux.fromIterable(eventService.getEvents());
    }


    @MessageMapping("getEventsByCategories")
    public Flux<EventDto> getEventsByCategories(List<String> categories) {
        return Flux.fromIterable(eventService.getEventsByCategories(categories));
    }
}
