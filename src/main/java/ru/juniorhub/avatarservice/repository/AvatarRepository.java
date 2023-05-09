package ru.juniorhub.avatarservice.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.juniorhub.avatarservice.entities.Avatar;

import java.util.Optional;

public interface AvatarRepository extends CrudRepository<Avatar, Long> {
    boolean existsByUsername(String username);

    Optional<Avatar> findByUsername(String username);

    @Modifying
    @Query("delete from avatar where username = :username")
    void deleteByUsername(@Param("username") String username);
}
