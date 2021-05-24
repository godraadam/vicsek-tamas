package dev.borgod.vicsektamas.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.borgod.vicsektamas.model.RegistrationToken;

public interface TokenRepo extends JpaRepository<RegistrationToken, Long> {
    Optional<RegistrationToken> findByToken(String token);
}
