package com.library.user.mapper;

import com.library.user.entity.User;
import com.library.user.model.UserRequestDto;
import com.library.user.model.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@MapperConfig
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDto convertToUserResponseDto(UserRequestDto userRequestDto);

    User convertToUser(UserRequestDto userRequestDto);

    List<UserResponseDto> convertAllToUserResponseDto(List<User> userList);

    UserResponseDto convertToUserResponseDto(User user);
}
