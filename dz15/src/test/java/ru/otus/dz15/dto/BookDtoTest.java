package ru.otus.dz15.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz15.domain.Author;
import ru.otus.dz15.domain.Book;
import ru.otus.dz15.domain.Genre;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

//@JsonTest
//@ComponentScan("ru.otus.dz15")
//@SpringBootApplication
//@RunWith(SpringRunner.class)
//@AutoConfigureJsonTesters
//@EnableAutoConfiguration
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//@SuppressWarnings("SpringJavaAutowiringInspection")
//@SpringBootTest
public class BookDtoTest {

//    @Autowired
    private JacksonTester<BookDto> json;

//    private Author author;
//    private Genre genre;
    private Book book;


    @Before
    public void setUp() throws Exception {

        JacksonTester.initFields(this, new ObjectMapper());
        Author author = new Author("Лев", "Толстой");
        author.setId(1);
        Genre genre = new Genre("роман-эпопея");
        genre.setId(1);
        book = new Book("Война и мир", author, genre);
    }

    @Test
    public void toDto() {
        BookDto dto = BookDto.toDto(book);
        assertEquals("Война и мир", dto.getBookTitle());
        assertEquals("роман-эпопея", dto.getGenre());
        assertEquals("Лев", dto.getAuthorName());
        assertEquals("Толстой", dto.getAuthorLastName());
//        assertThat();
    }

    @Test
    public void testSerializeBook() throws Exception {
        BookDto dto = BookDto.toDto(book);
//        assertThat().isEqualTo(json.write(dto).getJson());
//        assertEquals("{\"id\":null,\"bookTitle\":\"Война и мир\",\"authorName\":\"Лев\",\"authorLastName\":\"Толстой\",\"genre\":\"роман-эпопея\"}" , json.write(dto).getJson());
//        json.write(dto).getJson();
        assertThat(this.json.write(dto))
//                .isEqualToJson("{\"id\" : \"null\"}");
                .isStrictlyEqualToJson("{\"id\":null,\"bookTitle\":\"Война и мир\",\"authorName\":\"Лев\",\"authorLastName\":\"Толстой\",\"genre\":\"роман-эпопея\"}");
    }


    @Test
    public void testDeserializePerson() throws Exception {
        BookDto dto = this.json.read("/book-war.json").getObject();
        assertEquals("Война и мир", dto.getBookTitle());
        assertEquals("Толстой", dto.getAuthorLastName());
    }
}