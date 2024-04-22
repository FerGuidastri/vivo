package desafio.vivo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import desafio.vivo.model.dao.UserDao;
import desafio.vivo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService)).build();
    }

    @Test
    void createUser() throws Exception {
        UserDao user = buildMockUserDao();

        when(userService.createUser(any(UserDao.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test Name"));

        verify(userService, times(1)).createUser(any(UserDao.class));
    }

    @Test
    void updateUser() throws Exception {
        UserDao user = buildMockUserDao();

        when(userService.updateUser(any(UserDao.class))).thenReturn(user);

        mockMvc.perform(put("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test Name"));

        verify(userService, times(1)).updateUser(any(UserDao.class));
    }

    @Test
    void findUserByDocument() throws Exception {
        UserDao user = buildMockUserDao();

        when(userService.findUserByDocument("123456789")).thenReturn(user);

        mockMvc.perform(get("/users/document/123456789"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test Name"));

        verify(userService, times(1)).findUserByDocument("123456789");
    }

    @Test
    void findUserById() throws Exception {
        UserDao user = buildMockUserDao();

        when(userService.findUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/users/id/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Test Name"));

        verify(userService, times(1)).findUserById(1L);
    }

    private static UserDao buildMockUserDao() {
        return new UserDao(1L, "Test Email", "123456789", "Test Name");
    }
}