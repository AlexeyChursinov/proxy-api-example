package com.example.controller;

import com.example.dto.EventDto;
import com.example.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;

    @GetMapping("/all")
    public ResponseEntity<List<EventDto>> getEvents() {
        return ResponseEntity.ok(eventService.getEvents());
    }

}
