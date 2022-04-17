package com.library.user.service.impl;

import com.library.user.entity.User;
import com.library.user.model.UserRequestDto;
import com.library.user.model.UserResponseDto;

import java.util.ArrayList;
import java.util.List;

class UserServiceProvider {

    protected static User getUser(){

        final User user = new User();

        user.setName("Vedat");

        return user;
    }

    protected static User getUserWithAllFieldsFilled(){

        final User user = new User();

        user.setName("Vedat");
        user.setId(1L);

        return user;
    }

    protected static List<User> getUsers(){

        final List<User> users = new ArrayList<>();

        final User firstUser = new User();
        firstUser.setName("Vedat");

        final User secondUser  =new User();
        secondUser.setName("Vedat");

        users.add(firstUser);
        users.add(secondUser);

        return users;
    }

    protected static UserRequestDto getUserRequestDto(){

        final UserRequestDto userRequestDto = new UserRequestDto();

        userRequestDto.setName("Vedat");

        return userRequestDto;
    }

    protected static List<UserRequestDto> getUserRequestDtos(){

        final List<UserRequestDto> userRequestDtos = new ArrayList<>();

        final UserRequestDto firstUserRequestDto = new UserRequestDto();

        firstUserRequestDto.setName("Vedat");

        final UserRequestDto secondUserRequestDto = new UserRequestDto();

        secondUserRequestDto.setName("Vedat");

        userRequestDtos.add(firstUserRequestDto);
        userRequestDtos.add(secondUserRequestDto);

        return userRequestDtos;
    }

    protected static UserResponseDto getUserResponseDto(){

        final UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setName("Vedat");

        return userResponseDto;
    }

    protected static List<UserResponseDto> getUserResponseDtos(){

        final List<UserResponseDto> userResponseDtos = new ArrayList<>();

        final UserResponseDto firstUserResponseDto = new UserResponseDto();

        firstUserResponseDto.setName("Vedat");

        final UserResponseDto secondUserResponseDto = new UserResponseDto();

        secondUserResponseDto.setName("Vedat");

        userResponseDtos.add(firstUserResponseDto);
        userResponseDtos.add(secondUserResponseDto);

        return userResponseDtos;
    }

}
