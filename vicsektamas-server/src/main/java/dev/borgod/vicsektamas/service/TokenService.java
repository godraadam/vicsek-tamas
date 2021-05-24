package dev.borgod.vicsektamas.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.borgod.vicsektamas.exception.ResourceNotFoundException;
import dev.borgod.vicsektamas.model.RegistrationToken;
import dev.borgod.vicsektamas.repo.TokenRepo;

@Service
public class TokenService {

    @Autowired
    private TokenRepo tokenRepo;
    
    public RegistrationToken generate() {
        var token = new RegistrationToken();
        token.setTimeStamp(LocalDateTime.now());
        token.setToken(UUID.randomUUID().toString());
        return tokenRepo.save(token);
    }

    public boolean verifyToken(RegistrationToken token) {
        return tokenRepo.findByToken(token.getToken()).isPresent() && (token.getTimeStamp().compareTo(LocalDateTime.now()) < 0);
    }

    public void consumeToken(String tokenString) {
        var token = tokenRepo.findByToken(tokenString).orElseThrow(ResourceNotFoundException::new);
        tokenRepo.deleteById(token.getId());
    }

}
