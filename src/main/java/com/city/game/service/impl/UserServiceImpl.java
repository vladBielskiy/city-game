package com.city.game.service.impl;

import com.city.game.dto.UserDto;
import com.city.game.entity.User;
import com.city.game.exception.UserNotPlayingException;
import com.city.game.repository.UserRepository;
import com.city.game.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userRepository.save(modelMapper.map(userDto, User.class));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public Integer completeGameAndGetScore() {
        Optional<User> user = userRepository.findCurrentUser();
        if(!user.isPresent()) throw new UserNotPlayingException("To finish the game you need to start it");
        Integer score = user.get().getScore();
        userRepository.deleteAll();
        return score;
    }

    @Override
    public Integer getCountOfUsers() {
        return userRepository.getCountOfUsers();
    }

    @Override
    public UserDto getCurrentPlayer() {
        User user = userRepository.getCurrentUser();
        return modelMapper.map(user, UserDto.class);
    }
}
