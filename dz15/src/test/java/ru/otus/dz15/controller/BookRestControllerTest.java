package ru.otus.dz15.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.dz15.domain.Book;
import ru.otus.dz15.domain.BookDto;
import ru.otus.dz15.service.LibraryService;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@JsonTest
@RunWith(SpringRunner.class)
@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private JacksonTester<BookDto> json;

    @MockBean
    private LibraryService libraryService;

    @Configuration
    @ComponentScan(basePackageClasses = {BookRestController.class})
    public static class TestConf {
    }

    private Book book;
    private BookDto bookDto;

    @Before
    public void setUp() throws Exception {
        book = new Book();
        bookDto = new BookDto();
    }

    @Test
    public void addBook() throws Exception {
        this.mockMvc.perform(post("/api/books").contentType(MediaType.APPLICATION_JSON)
                .content(objectToStringJSON(bookDto))
//                .content("\"{\"id\" : \"1\"}\"")
        )
//                .andExpect(jsonPath("$.identifier", equalTo("123")))
                .andExpect(status().isOk());
    }

    @Test
    public void delBook() {
    }

    @Test
    public void updateBook() {
    }

    private static String objectToStringJSON(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}