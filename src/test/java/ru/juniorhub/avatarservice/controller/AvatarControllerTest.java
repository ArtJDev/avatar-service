package ru.juniorhub.avatarservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;
import ru.juniorhub.avatarservice.config.SecurityConfig;
import ru.juniorhub.avatarservice.entities.Avatar;
import ru.juniorhub.avatarservice.exceptions.AvatarNotFoundException;
import ru.juniorhub.avatarservice.service.AvatarService;

import java.util.HexFormat;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AvatarController.class)
@Import(SecurityConfig.class)
public class AvatarControllerTest {

//    private static final String ROLE_ADMIN = "ROLE_admin";
//    private static final String ROLE_USER = "ROLE_user";
//    private static final String USERNAME = "jack";
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @MockBean
//    AvatarService avatarService;
//
//    @MockBean
//    JwtDecoder jwtDecoder;
//
//    @Test
//    void whenGetBookExistingAndAuthenticatedThenShouldReturn200() throws Exception {
//
//        var expectedAvatar = Avatar.of(USERNAME, "file", HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d"));
//        given(avatarService.getAvatar(USERNAME)).willReturn(expectedAvatar);
//        mockMvc
//                .perform(get("/avatar")
//                        .with(jwt()))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void whenGetBookNotExistingAndAuthenticatedThenShouldReturn404() throws Exception {
//
//        given(avatarService.getAvatar(USERNAME)).willThrow(AvatarNotFoundException.class);
//        mockMvc
//                .perform(get("/avatar")
//                        .with(jwt()))
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    void whenDeleteBookNotAuthenticatedThenShouldReturn401() throws Exception {
//        var username = "jack";
//        mockMvc
//                .perform(delete("/avatar"))
//                .andExpect(status().isUnauthorized());
//    }
//
//    @Test
//    void whenPostAvatarThenShouldReturn201() throws Exception {
//
//        var bookToCreate = Avatar.of(USERNAME, "file", HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d"));
//        given(avatarService.saveAvatar(bookToCreate)).willReturn(bookToCreate);
//        mockMvc
//                .perform(post("/books")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(bookToCreate))
//                        .with(jwt().authorities(new SimpleGrantedAuthority(ROLE_ADMIN))))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    void whenPostBookWithCustomerRoleThenShouldReturn403() throws Exception {
//
//        var bookToCreate = Avatar.of(USERNAME, "Title", "Author", 9.90, "Polarsophia");
//        given(avatarService.addBookToCatalog(bookToCreate)).willReturn(bookToCreate);
//        mockMvc
//                .perform(post("/books")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(bookToCreate))
//                        .with(jwt().authorities(new SimpleGrantedAuthority(ROLE_USER))))
//                .andExpect(status().isForbidden());
//    }
//
//    @Test
//    void whenPostBookAndNotAuthenticatedThenShouldReturn403() throws Exception {
//
//        var bookToCreate = Avatar.of(USERNAME, "Title", "Author", 9.90, "Polarsophia");
//        mockMvc
//                .perform(post("/books")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(bookToCreate)))
//                .andExpect(status().isUnauthorized());
//    }
//
//    @Test
//    void whenPutBookWithEmployeeRoleThenShouldReturn200() throws Exception {
//
//        var bookToCreate = Avatar.of(USERNAME, "Title", "Author", 9.90, "Polarsophia");
//        given(avatarService.addBookToCatalog(bookToCreate)).willReturn(bookToCreate);
//        mockMvc
//                .perform(put("/books/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(bookToCreate))
//                        .with(jwt().authorities(new SimpleGrantedAuthority(ROLE_ADMIN))))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void whenPutBookWithCustomerRoleThenShouldReturn403() throws Exception {
//
//        var bookToCreate = Avatar.of(USERNAME, "Title", "Author", 9.90, "Polarsophia");
//        given(avatarService.addBookToCatalog(bookToCreate)).willReturn(bookToCreate);
//        mockMvc
//                .perform(put("/books/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(bookToCreate))
//                        .with(jwt().authorities(new SimpleGrantedAuthority(ROLE_USER))))
//                .andExpect(status().isForbidden());
//    }
//
//    @Test
//    void whenPutBookAndNotAuthenticatedThenShouldReturn401() throws Exception {
//
//        var bookToCreate = Avatar.of(USERNAME, "Title", "Author", 9.90, "Polarsophia");
//        mockMvc
//                .perform(put("/books/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(bookToCreate)))
//                .andExpect(status().isUnauthorized());
//    }
//

}
