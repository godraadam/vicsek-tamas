package dev.borgod.vicsektamas.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.borgod.vicsektamas.exception.UserAlreadyExistsException;
import dev.borgod.vicsektamas.model.AppUser;
import dev.borgod.vicsektamas.repo.UserRepo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    private AppUser testUser;

    @BeforeEach
    public void setup() {
        testUser = new AppUser();
        testUser.setEmail("test@test.com");
        testUser.setPassword("shhhh!");
        testUser.setPhoneNumber("012345678");
        testUser.setUsername("john_doe");
        userRepo.save(testUser);
    }

    @Test
    void whenUsernameTaken_UserAlreadyExistsException() {
        AppUser newUser = new AppUser();
        newUser.setEmail("whatev@asd.com");
        newUser.setPassword("secret");
        newUser.setPhoneNumber("098765432");
        newUser.setUsername("john_doe");
        assertThrows(UserAlreadyExistsException.class, () -> userService.registerUser(newUser));
    }

    @AfterEach
    public void cleanup() {
        userRepo.delete(testUser);
    }
}
