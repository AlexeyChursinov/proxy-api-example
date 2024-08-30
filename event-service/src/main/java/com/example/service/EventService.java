package com.example.service;

import com.example.dto.EventDto;

import java.util.List;

public interface EventService {

    List<EventDto> getEvents();

    List<EventDto> getEventsByCategories(List<String> categories);

}
