package com.city.game.service.impl;

import com.city.game.dto.CityDto;
import com.city.game.dto.UserDto;
import com.city.game.entity.City;
import com.city.game.exception.IncorrectWordException;
import com.city.game.exception.UserAlreadyPlayingException;
import com.city.game.repository.CityRepository;
import com.city.game.service.CityService;
import com.city.game.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityServiceImpl implements CityService {

    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(ModelMapper modelMapper, UserService userService, CityRepository cityRepository) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.cityRepository = cityRepository;
    }

    @Override
    public CityDto getFirstCity() {
        Integer countOfUsers = userService.getCountOfUsers();
        if(countOfUsers > 0)
            throw new UserAlreadyPlayingException("The game is already played by a player, end the game to start over");
        UserDto userDto = new UserDto();
        City city = cityRepository.getRandomCity();
        CityDto cityDto = modelMapper.map(city, CityDto.class);
        userDto.setLastCity(cityDto);
        userDto.setScore(0);
        userService.saveUser(userDto);
        return cityDto;
    }

    @Override
    public CityDto getNextCity(String word) {
      UserDto userDto = userService.getCurrentPlayer();
      String lastCity = userDto.getLastCity().getName();
      if(!Character.toString(lastCity.charAt(lastCity.length() - 1)).equalsIgnoreCase(Character.toString(word.charAt(0))))
          throw new IncorrectWordException("Word starts with wrong letter!!! Previous city: " + lastCity);
      City city = cityRepository.getNextCity(Character.toString(word.charAt(word.length() - 1)).toUpperCase());
      CityDto nextCity = modelMapper.map(city, CityDto.class);
      userDto.setScore(userDto.getScore() + 1);
      userDto.setLastCity(nextCity);
      userService.saveUser(userDto);
      return nextCity;
    }

}
