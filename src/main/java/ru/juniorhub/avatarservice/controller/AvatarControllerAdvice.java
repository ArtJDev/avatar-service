package ru.juniorhub.avatarservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.juniorhub.avatarservice.exceptions.AvatarAlreadyExistsException;
import ru.juniorhub.avatarservice.exceptions.AvatarNotFoundException;

@RestControllerAdvice
public class AvatarControllerAdvice {

    @ExceptionHandler(AvatarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String avatarNotFoundHandler(AvatarNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(AvatarAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String avatarAlreadyExistsHandler(AvatarAlreadyExistsException ex) {
        return ex.getMessage();
    }
}
