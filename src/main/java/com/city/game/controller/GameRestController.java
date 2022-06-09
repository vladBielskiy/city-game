package com.city.game.controller;

import com.city.game.dto.CityDto;
import com.city.game.service.CityService;
import com.city.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/game")
public class GameRestController {

    private final UserService userService;
    private final CityService cityService;

    @Autowired
    public GameRestController(UserService userService, CityService cityService) {
        this.userService = userService;
        this.cityService = cityService;
    }

    @GetMapping(value = "/begin")
    public ResponseEntity<CityDto> startOfTheGame(){
        CityDto firstCity = cityService.getFirstCity();
        return new ResponseEntity<>(firstCity, HttpStatus.OK);
    }

    @GetMapping(value = "/next")
    public ResponseEntity<CityDto> nextCity(@RequestParam(name = "word") String word){
        CityDto nextCity = cityService.getNextCity(word);
        return new ResponseEntity<>(nextCity, HttpStatus.OK);
    }

    @PostMapping(value = "/end")
    public ResponseEntity<String> endOfTheGame(){
        Integer userScore = userService.completeGameAndGetScore();
        return new ResponseEntity<>("Thanks for playing! Your score: " + userScore, HttpStatus.OK);
    }
}
