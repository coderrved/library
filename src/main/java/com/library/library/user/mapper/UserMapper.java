package com.library.library.user.mapper;

import com.library.library.user.entity.User;
import com.library.library.user.model.UserRequestDto;
import com.library.library.user.model.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDto convertFromUserRequestDtoToUserResponseDto(UserRequestDto userRequestDto);

    User convertFromUserRequestDtoToUser(UserRequestDto userRequestDto);

    List<UserResponseDto> convertFromUserListToUserResponseDtoList(List<User> userList);

    UserResponseDto convertFromUserToUserResponseDto(User user);
}
