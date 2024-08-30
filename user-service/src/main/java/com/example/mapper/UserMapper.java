package com.example.mapper;

import com.example.dto.UserDto;
import com.example.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
