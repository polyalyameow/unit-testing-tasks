package com.example.unittesting_tasks;

import com.example.unittesting_tasks.user.User;
import com.example.unittesting_tasks.user.UserRepository;
import com.example.unittesting_tasks.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User(1L, "TestUser", "testuser@testuser.com");
        when(userRepository.existsById(user.getId())).thenReturn(false);

        userService.createUser(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testCreateUserAlreadyExists() {
        User user = new User(1L, "TestUser", "testuser@testuser.com");
        when(userRepository.existsById(user.getId())).thenReturn(true);

        assertThrows(IllegalStateException.class, () -> userService.createUser(user));
    }

    @Test
    void testGetUserById() {
        User user = new  User(1L, "TestUser", "testuser@testuser.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        assertEquals(user, userService.getUserById(1L));
    }

    @Test
    void testDeleteUser() {
        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }

}
