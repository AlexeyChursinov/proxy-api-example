package com.example.service;

import com.example.dto.EventDto;
import com.example.mapper.EventMapper;
import com.example.model.Event;
import com.example.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public List<EventDto> getEvents() {
        List<Event> events = eventRepository.findAll();
        return eventMapper.toDto(events);
    }

    @Override
    public List<EventDto> getEventsByCategories(List<String> categories) {
        List<Event> events = eventRepository.findByCategoryIn(categories);
        return eventMapper.toDto(events);
    }
}
