package ru.juniorhub.avatarservice.entities;

import org.springframework.data.annotation.Id;

public record AvatarDto(
        @Id
        Long id,
        String filename,
        String type,
        Long size,
        byte[] avatar
) {
        public static AvatarDto of(String filename, byte[] avatar) {
                return new AvatarDto(null, filename, null, 0L, avatar);
        }
}
