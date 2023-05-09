package ru.juniorhub.avatarservice.exceptions;

public class AvatarAlreadyExistsException extends RuntimeException {
    public AvatarAlreadyExistsException(String username) {
        super("Аватар пользователя " + username + " уже существует");
    }
}
