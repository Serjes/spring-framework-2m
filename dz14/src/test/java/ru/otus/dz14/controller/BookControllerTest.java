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

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

//    @MockBean
//    private BookRepository bookRepository;

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
//    private Matcher<String> matcher;
    List<Book> books;
    BookDto bookDto;

    @Before
    public void setUp() throws Exception {
        author = new Author("Лев", "Толстой");
        author.setId(1);
        genre = new Genre("роман-эпопея");
        genre.setId(1);
        book = new Book("Война и мир", author, genre);
        comment = new Comment("Эпично, но слишком затянуто.", book);
//        matcher = containsString(book.getTitle());
        books = Arrays.asList(book);
        bookDto = new BookDto(1, "Мертвые души", "Николай", "Гоголь", "поэма");
    }

    @Test
    public void booksPage() throws Exception {
//        List<Book> books = Arrays.asList(book);
        Mockito.when(libraryService.listBooks()).thenReturn(books);
        mvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(book.getTitle())))
                .andExpect(view().name("books"));
    }

    @Test
    public void delete() throws Exception {

//        Mockito.when(libraryService.delBook(bookDto.getId()));
        mvc.perform(post("/books/delete/").flashAttr("bookDto", bookDto))
//                .andExpect(status().isFound())
//                .andDo(print())
//                .andDo(MockMvcResultHandlers.print())
                .andExpect(redirectedUrl("/books"));
//                .andDo(print());
//        BookDto bookDto = new BookDto();

    }

    @Test
    public void saveBook() throws Exception {
//        Mockito.when(libraryService.listBooks()).
        mvc.perform(post("/books/add")
                .flashAttr("bookDto", bookDto))
//                .andDo(print())
                .andExpect(redirectedUrl("/books"));

//        mvc.perform(get("books"))
//                .andExpect(content().string(containsString(bookDto.getBookTitle())));
    }

    @Test
    public void updateBook() {
    }
}