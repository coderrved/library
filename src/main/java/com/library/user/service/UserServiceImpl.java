package com.library.library.user.service;

import com.library.library.user.repository.UserRepository;
import com.library.library.user.entity.User;
import com.library.library.user.exception.UserNotFound;
import com.library.library.user.mapper.UserMapper;
import com.library.library.user.model.UserRequestDto;
import com.library.library.user.model.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserResponseDto findUserById(Long id){

        final User user = findUser(id);

        final UserResponseDto userResponseDto = UserMapper.INSTANCE.convertFromUserToUserResponseDto(user);

        logger.info("User : {} " ,userResponseDto);

        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> findAllUsers() {

        final List<User> userList = userRepository.findAll();

        final List<UserResponseDto> userResponseDtoList = UserMapper.INSTANCE.convertFromUserListToUserResponseDtoList(userList);

        logger.info("All Users : {} " ,userResponseDtoList);

        return userResponseDtoList;
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {

        final User user = UserMapper.INSTANCE.convertFromUserRequestDtoToUser(userRequestDto);

        userRepository.save(user);

        final UserResponseDto userResponseDto = UserMapper.INSTANCE.convertFromUserRequestDtoToUserResponseDto(userRequestDto);

        logger.info("User : {} " ,userResponseDto);

        return userResponseDto;
    }

    @Override
    public UserResponseDto updateUserById(Long id, UserRequestDto userRequestDto) {

        final User convertedUser = UserMapper.INSTANCE.convertFromUserRequestDtoToUser(userRequestDto);

        final User user = findUser(id);

        convertedUser.setId(user.getId());

        userRepository.save(convertedUser);

        final UserResponseDto userResponseDto = UserMapper.INSTANCE.convertFromUserRequestDtoToUserResponseDto(userRequestDto);

        logger.info("User : {} " ,userResponseDto);

        return userResponseDto;
    }

    @Override
    public UserResponseDto deleteUserById(Long id) {

        final User user = findUser(id);

        userRepository.delete(user);

        final UserResponseDto userResponseDto = UserMapper.INSTANCE.convertFromUserToUserResponseDto(user);

        logger.info("User : {} " ,userResponseDto);

        return userResponseDto;
    }

    @Override
    public void deleteAllUser() {

        userRepository.deleteAll();
    }

    private User findUser(Long id){

        final User user = userRepository.findById(id).orElseThrow(
                ()-> new UserNotFound("User with id :"+ id +" could not be found."));

        return user;
    }

}
