package dev.borgod.vicsektamas.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.borgod.vicsektamas.exception.IncorrectCredentialsException;
import dev.borgod.vicsektamas.exception.UserAlreadyExistsException;
import dev.borgod.vicsektamas.model.Manager;
import dev.borgod.vicsektamas.model.RegistrationToken;
import dev.borgod.vicsektamas.model.Role;
import dev.borgod.vicsektamas.repo.ManagerRepo;

@Service
public class ManagerService {
    
    
    @Autowired
    private ManagerRepo managerRepo;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Manager registerManager(Manager manager, RegistrationToken token) throws UserAlreadyExistsException, IncorrectCredentialsException {
        if (!userService.canRegister(manager)) {
            throw new UserAlreadyExistsException();
        }
        if (!tokenService.verifyToken(token)) {
            throw new IncorrectCredentialsException();
        }
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        manager.setRole(Role.MANAGER);
        manager.setServices(Collections.emptyList());
        tokenService.consumeToken(token.getToken());
        return managerRepo.save(manager);
    }

}
