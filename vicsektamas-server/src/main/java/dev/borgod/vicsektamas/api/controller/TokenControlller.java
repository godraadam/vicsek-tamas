package dev.borgod.vicsektamas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.borgod.vicsektamas.model.RegistrationToken;
import dev.borgod.vicsektamas.service.TokenService;

@RestController
public class TokenControlller {
    
    @Autowired
    private TokenService tokenService;

    @GetMapping("/admin/api/token/generate")
    public RegistrationToken getToken() {
        return tokenService.generate();
    }
}
