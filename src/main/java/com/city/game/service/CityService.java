package com.city.game.service;

import com.city.game.dto.CityDto;

public interface CityService {

    CityDto getFirstCity();

    CityDto getNextCity(String word);
}
