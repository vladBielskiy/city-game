package com.city.game.service;

import com.city.game.dto.UserDto;

public interface UserService {

    UserDto saveUser(UserDto userDto);

    Integer completeGameAndGetScore();

    Integer getCountOfUsers();

    UserDto getCurrentPlayer();
}
