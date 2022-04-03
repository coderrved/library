package com.library.library.user.controller;

import com.library.library.user.model.UserRequestDto;
import com.library.library.user.model.UserResponseDto;
import com.library.library.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id){

        final UserResponseDto userResponseDto = userServiceImpl.findUserById(id);

        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping
    public List<UserResponseDto> getAllUser(){

        final List<UserResponseDto> allUser = userServiceImpl.findAllUsers();

        return allUser;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserRequestDto userRequestDto){

        final UserResponseDto userResponseDto = userServiceImpl.saveUser(userRequestDto);

        return ResponseEntity.ok(userResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUserById(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){

        final UserResponseDto userResponseDto = userServiceImpl.updateUserById(id, userRequestDto);

        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> deleteUserById(@PathVariable Long id){

        final UserResponseDto userResponseDto = userServiceImpl.deleteUserById(id);

        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllUser(){

        userServiceImpl.deleteAllUser();

        return ResponseEntity.noContent().build();
    }
}
