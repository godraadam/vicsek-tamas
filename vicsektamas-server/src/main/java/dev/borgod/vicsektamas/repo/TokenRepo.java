package dev.borgod.vicsektamas.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.borgod.vicsektamas.model.RegistrationToken;
@Repository
public interface TokenRepo extends JpaRepository<RegistrationToken, Long> {
    Optional<RegistrationToken> findByToken(String token);
}
