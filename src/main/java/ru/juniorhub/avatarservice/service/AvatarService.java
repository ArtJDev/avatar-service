package ru.juniorhub.avatarservice.service;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.juniorhub.avatarservice.entities.Avatar;
import ru.juniorhub.avatarservice.exceptions.AvatarAlreadyExistsException;
import ru.juniorhub.avatarservice.exceptions.AvatarNotFoundException;
import ru.juniorhub.avatarservice.repository.AvatarRepository;

import java.io.IOException;

@Service
public class AvatarService {

    private final AvatarRepository avatarRepository;

    public AvatarService(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
    }

    public Iterable<Avatar> getAll() {
        return avatarRepository.findAll();
    }

    public Avatar getAvatar(Jwt principal) {
        String username = principal.getClaims().get("preferred_username").toString();
        return avatarRepository.findByUsername(username)
                .orElseThrow(() -> new AvatarNotFoundException(username));
    }

    public Avatar saveAvatar(Jwt principal, MultipartFile file) throws IOException {
        String username = principal.getClaims().get("preferred_username").toString();
        if (avatarRepository.existsByUsername(username)) {
            throw new AvatarAlreadyExistsException(username);
        }
        return avatarRepository.save(new Avatar(null, username, file.getOriginalFilename(),
                file.getContentType(), file.getSize(), file.getBytes()));
    }

    public Avatar updateAvatar(Jwt principal, MultipartFile file) {
        String username = principal.getClaims().get("preferred_username").toString();
        return avatarRepository.findByUsername(username)
                .map(existingAvatar -> {
                    try {
                        var avatarToUpdate = new Avatar(
                                existingAvatar.id(),
                                existingAvatar.username(),
                                file.getOriginalFilename(),
                                file.getContentType(),
                                file.getSize(),
                                file.getBytes());
                        return avatarRepository.save(avatarToUpdate);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElseGet(() -> {
                    try {
                        return saveAvatar(principal, file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public void deleteAvatar(Jwt principal) {
        String username = principal.getClaims().get("preferred_username").toString();
        avatarRepository.deleteByUsername(username);
    }
}
