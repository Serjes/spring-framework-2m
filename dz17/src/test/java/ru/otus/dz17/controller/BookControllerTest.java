package ru.otus.dz17.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private LibraryService libraryService;
//
//    @Configuration
//    @ComponentScan(basePackageClasses = {BookController.class})
//    public static class TestConf {
//    }
//
//
//    @Test
//    public void booksPage() throws Exception {
//        mvc.perform(get("/books"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("books"));
//    }

}