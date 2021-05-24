package dev.borgod.vicsektamas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.borgod.vicsektamas.exception.IncorrectCredentialsException;
import dev.borgod.vicsektamas.exception.UserAlreadyExistsException;
import dev.borgod.vicsektamas.model.Manager;
import dev.borgod.vicsektamas.model.RegistrationToken;
import dev.borgod.vicsektamas.repo.ManagerRepo;
import dev.borgod.vicsektamas.repo.TokenRepo;
import dev.borgod.vicsektamas.repo.UserRepo;

@Service
public class ManagerService {
    

    @Autowired
    private UserRepo userRepo;
    
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
        return managerRepo.save(manager);
    }

}
