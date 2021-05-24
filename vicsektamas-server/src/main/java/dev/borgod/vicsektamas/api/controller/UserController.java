package dev.borgod.vicsektamas.api.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.borgod.vicsektamas.api.dto.UserDTO;
import dev.borgod.vicsektamas.api.dto.UserLoginDTO;
import dev.borgod.vicsektamas.api.dto.UserRegisterDTO;
import dev.borgod.vicsektamas.exception.UserNotFoundException;
import dev.borgod.vicsektamas.model.AppUser;
import dev.borgod.vicsektamas.repo.UserRepo;
import dev.borgod.vicsektamas.service.UserService;

@RestController
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;
    
    @GetMapping("/api/user/id/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        var user = userRepo.findById(id).orElseThrow(UserNotFoundException::new);
        return modelMapper.map(user, UserDTO.class);
    }

    @GetMapping("/api/user/name/{username}")
    public UserDTO getUserById(@PathVariable String username) {
        var user = userRepo.findByEmail(username).orElseThrow(UserNotFoundException::new);
        return modelMapper.map(user, UserDTO.class);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody UserLoginDTO dto) {
        var user = userService.loginUser(modelMapper.map(dto, AppUser.class));
        return modelMapper.map(user, UserDTO.class);
    }

    @PostMapping("/register/user")
    public UserDTO register(@RequestBody UserRegisterDTO dto) {
        var user = userService.registerUser(modelMapper.map(dto, AppUser.class));
        return modelMapper.map(user, UserDTO.class);
    }


}
