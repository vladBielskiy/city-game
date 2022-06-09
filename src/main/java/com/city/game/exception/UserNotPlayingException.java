package com.city.game.exception;

public class UserNotPlayingException extends RuntimeException{

    public UserNotPlayingException(String message) {
        super(message);
    }
}
