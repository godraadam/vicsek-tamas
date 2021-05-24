package dev.borgod.vicsektamas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.borgod.vicsektamas.exception.IncorrectCredentialsException;
import dev.borgod.vicsektamas.exception.UserAlreadyExistsException;
import dev.borgod.vicsektamas.exception.UserNotFoundException;
import dev.borgod.vicsektamas.model.AppUser;
import dev.borgod.vicsektamas.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AppUser registerUser(AppUser userToRegister) throws UserAlreadyExistsException {
        if (!canRegister(userToRegister)) {
            throw new UserAlreadyExistsException();
        }
        userToRegister.setPassword(passwordEncoder.encode(userToRegister.getPassword()));
        return userRepo.save(userToRegister);
    }

    public boolean canRegister(AppUser userToRegister) {
        return userRepo.findByUsername(userToRegister.getUsername()).isEmpty()
                && userRepo.findByEmail(userToRegister.getEmail()).isEmpty();

    }

    public AppUser loginUser(AppUser userToLogin) throws UserNotFoundException, IncorrectCredentialsException {
        var user = userRepo.findByUsername(userToLogin.getUsername()).orElseThrow(UserNotFoundException::new);
        if (!passwordEncoder.matches(userToLogin.getPassword(), user.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        return user;
    }

}
