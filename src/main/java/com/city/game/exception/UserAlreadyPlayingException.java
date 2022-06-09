package com.city.game.exception;

public class UserAlreadyPlayingException extends RuntimeException{

    public UserAlreadyPlayingException(String message) {
        super(message);
    }
}
