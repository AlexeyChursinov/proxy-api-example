package com.example.mapper;

import com.example.dto.EventDto;
import com.example.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper extends Mappable<Event, EventDto> {
}
