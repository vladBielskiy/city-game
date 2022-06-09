package com.city.game.exception.controller;

import com.city.game.exception.IncorrectWordException;
import com.city.game.exception.UserAlreadyPlayingException;
import com.city.game.exception.UserNotPlayingException;
import com.city.game.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionRestController {

    @ExceptionHandler({ IncorrectWordException.class, UserAlreadyPlayingException.class, UserNotPlayingException.class})
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        String message =  e.getMessage();
        ExceptionResponse response = new ExceptionResponse(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
