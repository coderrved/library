package com.library.library.user.service;

import com.library.library.user.model.UserRequestDto;
import com.library.library.user.model.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserResponseDto> findAllUsers();

    UserResponseDto findUserById(Long id);

    UserResponseDto saveUser(UserRequestDto userRequestDto);

    UserResponseDto updateUserById(Long id, UserRequestDto userRequestDto);

    UserResponseDto deleteUserById(Long id);

    void deleteAllUser();
}
