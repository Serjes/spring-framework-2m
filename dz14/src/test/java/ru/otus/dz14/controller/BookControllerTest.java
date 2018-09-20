package ru.otus.dz14.controller;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.dz14.domain.Author;
import ru.otus.dz14.domain.Book;
import ru.otus.dz14.domain.Comment;
import ru.otus.dz14.domain.Genre;
import ru.otus.dz14.repository.AuthorRepository;
import ru.otus.dz14.repository.BookRepository;
import ru.otus.dz14.repository.CommentRepository;
import ru.otus.dz14.repository.GenreRepository;
import ru.otus.dz14.service.CommentService;
import ru.otus.dz14.service.LibraryService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

//@WebAppConfiguration
@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
//@DataJpaTest
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private LibraryService libraryService;

    @MockBean
    private CommentService commentService;

    @MockBean
    private AuthorRepository authorRepository;

    @MockBean
    private GenreRepository genreRepository;

    @MockBean
    private CommentRepository commentRepository;

    @Configuration
    @ComponentScan(basePackageClasses = { BookController.class })
    public static class TestConf {

    }

    private Author author;
    private Genre genre;
    private Book book;
    private Comment comment;
    private Matcher<String> matcher;

    @Before
    public void setUp() throws Exception {
        author = new Author("Лев", "Толстой");
        author.setId(1);
//        author.setFirstName("Лев");
//        author.setLastName("Толстой");
//        authorRepository.save(author);
        genre = new Genre("роман-эпопея");
        genre.setId(1);
//        genre.setName("роман-эпопея");
//        genreRepository.save(genre);
        book = new Book("Война и мир", author, genre);
//        bookRepository.save(book);
        comment = new Comment("Эпично, но слишком затянуто.", book);
        matcher = containsString(book.getTitle());
    }

    @Test
    public void booksPage() throws Exception {
        List<Book> books = Arrays.asList(book);
        Mockito.when(libraryService.listBooks()).thenReturn(books);
        mvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().string(matcher))
                .andExpect(view().name("books"));
    }

    @Test
    public void delete() {
    }

    @Test
    public void saveBook() {
    }

    @Test
    public void updateBook() {
    }
}