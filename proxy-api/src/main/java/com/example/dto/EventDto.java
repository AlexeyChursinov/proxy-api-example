package com.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventDto {

    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private String location;
    private String category;

}
