package ru.juniorhub.avatarservice.entities;

import org.springframework.data.annotation.Id;

public record Avatar(
        @Id
        Long id,
        String username,
        String filename,
        String type,
        Long size,
        byte[] avatar
) {
        public static Avatar of(String username, String filename, byte[] avatar) {
                return new Avatar(null, username, filename, null, 0L, avatar);
        }
}
