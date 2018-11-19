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

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private LibraryService libraryService;
//
//    @Configuration
//    @ComponentScan(basePackageClasses = {BookRestController.class})
//    public static class TestConf {
//    }
//
//    private Book book;
//    private Book updatedBook;
//
//    @Before
//    public void setUp() throws Exception {
//        Author author = new Author("Лев", "Толстой");
//        author.setId(1);
//        Genre genre = new Genre("роман-эпопея");
//        genre.setId(1);
//        book = new Book("Война и мир", author, genre);
//        book.setId(1);
//        genre.setName("роман");
//        updatedBook = new Book("Анна Каренина", author, genre);
//    }
//
//    @Test
//    public void addBook() throws Exception {
//
//
//        when(libraryService.addBook("Война и мир","Лев", "Толстой", "роман-эпопея")).thenReturn(book);
//        this.mockMvc.perform(post("/api/books").contentType(MediaType.APPLICATION_JSON)
//                .content("{\"bookTitle\":\"Война и мир\",\"authorName\":\"Лев\",\"authorLastName\":\"Толстой\",\"genre\":\"роман-эпопея\"}")
//        )
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value(book.getTitle()))
//                .andDo(print())
//                .andExpect(content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8_VALUE));
//    }
//
//    @Test
//    public void delBook() throws Exception {
//        this.mockMvc.perform(delete("/api/books/{id}", book.getId())
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"id\" : \"1\"}")
//        )
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void updateBook() throws Exception {
//        when(libraryService.updateBook(1,"Анна Каренина","Лев", "Толстой", "роман")).thenReturn(updatedBook);
//        this.mockMvc.perform(put("/api/books/{id}", 1)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"bookTitle\":\"Анна Каренина\",\"authorName\":\"Лев\",\"authorLastName\":\"Толстой\",\"genre\":\"роман\"}")
//        )
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value(updatedBook.getTitle()))
//                .andExpect(content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8_VALUE));
//    }

}