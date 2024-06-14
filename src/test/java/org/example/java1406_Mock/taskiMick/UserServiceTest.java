package org.example.java1406_Mock.taskiMick;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


public class UserServiceTest extends TestCase {
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testPlaceUser() {
        userService.placeUser(user);
        verify(userRepository).save(user);
    }

    @Test
    public void testGetUser() {
        userService.getUser(1);
        verify(userRepository).findById(1);
    }
}