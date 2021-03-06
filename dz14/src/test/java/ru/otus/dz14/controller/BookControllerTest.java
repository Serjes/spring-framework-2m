package ru.otus.dz14.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.dz14.domain.*;
import ru.otus.dz14.service.CommentService;
import ru.otus.dz14.service.LibraryService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LibraryService libraryService;

    @MockBean
    private CommentService commentService;

    @Configuration
    @ComponentScan(basePackageClasses = {BookController.class})
    public static class TestConf {
    }

    private Author author;
    private Genre genre;
    private Book book;
    private Comment comment;
    private List<Book> books;
    private BookDto bookDto;

    @Before
    public void setUp() throws Exception {
        author = new Author("Лев", "Толстой");
        author.setId(1);
        genre = new Genre("роман-эпопея");
        genre.setId(1);
        book = new Book("Война и мир", author, genre);
        book.setId(1);
        comment = new Comment("Эпично, но слишком затянуто.", book);
        books = Arrays.asList(book);
        bookDto = new BookDto(1, "Мертвые души", "Николай", "Гоголь", "поэма");
    }

    @Test
    public void booksPage() throws Exception {
        Mockito.when(libraryService.listBooks()).thenReturn(books);
        mvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(book.getTitle())))
                .andExpect(view().name("books"));
    }

    @Test
    public void delete() throws Exception {
        mvc.perform(post("/books/delete/").flashAttr("bookDto", bookDto))
                .andExpect(redirectedUrl("/books"));
    }

    @Test
    public void saveBook() throws Exception {
        mvc.perform(post("/books/add")
                .flashAttr("bookDto", bookDto))
                .andExpect(redirectedUrl("/books"));
    }

    @Test
    public void updateBook() throws Exception {
        mvc.perform(post("/books/add/1")
                .flashAttr("bookDto", bookDto))
                .andExpect(redirectedUrl("/books"));
    }

    @Test
    public void addBookPage() throws Exception {
        mvc.perform(get("/addbook"))
                .andExpect(status().isOk());
    }

    @Test
    public void editBookPage() throws Exception {
        Mockito.when(libraryService.findBookById(1)).thenReturn(Optional.of(book));
        mvc.perform(get("/addbook/edit?id=" + book.getId()))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString(book.getTitle())));
    }
}