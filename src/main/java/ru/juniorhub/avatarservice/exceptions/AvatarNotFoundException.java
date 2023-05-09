package ru.juniorhub.avatarservice.exceptions;

public class AvatarNotFoundException extends RuntimeException {
    public AvatarNotFoundException(String username) {
        super("Аватар пользователя " + username + " не найден");
    }
}
