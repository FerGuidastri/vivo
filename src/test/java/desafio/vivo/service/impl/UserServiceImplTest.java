package desafio.vivo.service.impl;

import desafio.vivo.model.dao.UserDao;
import desafio.vivo.model.entity.UserModel;
import desafio.vivo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void createUser() {
        UserModel user = new UserModel();
        String name = "Test Name";
        user.setId(1L);
        user.setName(name);

        when(userRepository.save(any(UserModel.class))).thenReturn(user);

        UserDao createdUser = userService.createUser(user.toUserDao());

        assertThat(createdUser).isNotNull();
        assertEquals(1L, createdUser.getId());
        assertEquals(name, createdUser.getName());
        verify(userRepository, times(1)).save(any(UserModel.class));
    }

    @Test
    void updateUser() {
        String name = "Test Name";
        UserModel user = new UserModel();
        user.setId(1L);
        user.setName(name);

        when(userRepository.existsById(1L)).thenReturn(true);
        when(userRepository.save(any(UserModel.class))).thenReturn(user);

        UserDao updatedUser = userService.updateUser(user.toUserDao());

        assertThat(updatedUser).isNotNull();
        assertEquals(1L, updatedUser.getId());
        assertEquals(name, updatedUser.getName());
        verify(userRepository, times(1)).save(any(UserModel.class));
    }

    @Test
    void findUserByDocument() {
        String document = "123456789";
        String name = "Test Name";
        long userId = 1L;
        UserModel user = new UserModel();
        user.setId(userId);
        user.setName(name);
        user.setDocument(document);

        when(userRepository.findByDocument(document)).thenReturn(Optional.of(user));

        UserDao foundUser = userService.findUserByDocument(document);

        assertThat(foundUser).isNotNull();
        assertEquals(userId, foundUser.getId());
        assertEquals(name, foundUser.getName());
        verify(userRepository, times(1)).findByDocument(document);
    }

    @Test
    void findUserById() {
        long userId = 1L;
        String name = "Test Name";
        UserModel user = new UserModel();
        user.setId(userId);
        user.setName(name);

        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(user));

        UserDao foundUser = userService.findUserById(userId);

        assertThat(foundUser).isNotNull();
        assertEquals(userId, foundUser.getId());
        assertEquals(name, foundUser.getName());
        verify(userRepository, times(1)).findById(userId);
    }
}