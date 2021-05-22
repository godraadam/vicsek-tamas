package dev.borgod.vicsektamas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dev.borgod.vicsektamas.model.AppUser;
import dev.borgod.vicsektamas.repo.UserRepo;


public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        return User.builder().
            username(user.getUsername()).
            password(user.getPassword()).
            roles(user.getRole().name()).
            build();
    }
}
