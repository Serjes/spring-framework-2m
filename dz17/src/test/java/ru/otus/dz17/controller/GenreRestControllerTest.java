package ru.otus.dz17.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.dz17.domain.Genre;
import ru.otus.dz17.service.LibraryService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GenreRestController.class)
public class GenreRestControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private LibraryService libraryService;
//
//    @Configuration
//    @ComponentScan(basePackageClasses = {GenreRestController.class})
//    public static class TestConf {
//    }
//
//    private Genre genre;
//
//    @Before
//    public void setUp() throws Exception {
//        genre =  new Genre();
//        genre.setId(1);
//    }
//
//    @Test
//    public void delGenre() throws Exception {
//        this.mockMvc.perform(delete("/api/genres/{id}", genre.getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"id\" : \"1\"}")
//        )
//                .andExpect(status().isOk());
//    }
}