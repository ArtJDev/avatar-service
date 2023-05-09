package ru.juniorhub.avatarservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.juniorhub.avatarservice.entities.Avatar;
import ru.juniorhub.avatarservice.service.AvatarService;

import java.io.IOException;

@RestController
@RequestMapping("/avatar")
public class AvatarController {
    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @GetMapping("/all")
    public Iterable<Avatar> getAll() {
        return avatarService.getAll();
    }

    @GetMapping
    public Avatar get(@AuthenticationPrincipal Jwt principal) {
        return avatarService.getAvatar(principal);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Avatar post(@AuthenticationPrincipal Jwt principal, @RequestParam("avatar") MultipartFile file) throws IOException {
        return avatarService.saveAvatar(principal, file);
    }

    @PutMapping
    public Avatar put(@AuthenticationPrincipal Jwt principal, @RequestParam("avatar") MultipartFile file) {
        return avatarService.updateAvatar(principal, file);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@AuthenticationPrincipal Jwt principal) {
        avatarService.deleteAvatar(principal);
    }
}
