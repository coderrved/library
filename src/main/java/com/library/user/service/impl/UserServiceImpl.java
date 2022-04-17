package com.library.user.service.impl;

import com.library.address.repository.AddressRepository;
import com.library.user.entity.User;
import com.library.user.exception.UserNotFound;
import com.library.user.mapper.UserMapper;
import com.library.user.model.UserRequestDto;
import com.library.user.model.UserResponseDto;
import com.library.user.repository.UserRepository;
import com.library.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserResponseDto findUserById(Long id){

        final User user = findUser(id);

        final UserResponseDto userResponseDto = UserMapper.INSTANCE.convertToUserResponseDto(user);

        logger.info("User : {} " ,userResponseDto);

        return userResponseDto;
    }

    @Override
    public List<UserResponseDto> findAllUsers() {

        final List<User> userList = userRepository.findAll();

        final List<UserResponseDto> userResponseDtoList = UserMapper.INSTANCE.convertAllToUserResponseDto(userList);

        logger.info("All Users : {} " ,userResponseDtoList);

        return userResponseDtoList;
    }

    @Transactional
    @Override
    public void saveUser(UserRequestDto userRequestDto) {

        final User user = UserMapper.INSTANCE.convertToUser(userRequestDto);

        userRepository.save(user);

        logger.info("Created User : {} " ,user);
    }

    @Override
    public UserResponseDto updateUserById(Long id, UserRequestDto userRequestDto) {

        final User convertedUser = UserMapper.INSTANCE.convertToUser(userRequestDto);

        final User user = findUser(id);

        convertedUser.setId(user.getId());

        userRepository.save(convertedUser);

        final UserResponseDto userResponseDto = UserMapper.INSTANCE.convertToUserResponseDto(userRequestDto);

        logger.info(" Updated User : {} " ,userResponseDto);

        return userResponseDto;
    }

    @Override
    public void deleteUserById(Long id) {

        final User user = findUser(id);

        userRepository.delete(user);

        logger.info("Deleted User : {} " ,user);

    }

    @Override
    public void deleteAllUser() {

        userRepository.deleteAll();
    }

    private User findUser(Long id){

        return userRepository.findById(id).orElseThrow(
                ()-> new UserNotFound("User with id :"+ id +" could not be found."));
    }

}
