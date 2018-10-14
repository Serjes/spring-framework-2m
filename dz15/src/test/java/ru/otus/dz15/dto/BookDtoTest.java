package ru.otus.dz15.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;
import ru.otus.dz15.domain.Author;
import ru.otus.dz15.domain.Book;
import ru.otus.dz15.domain.Genre;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BookDtoTest {

    private JacksonTester<BookDto> json;

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
    }

    @Test
    public void testSerializeBook() throws Exception {
        BookDto dto = BookDto.toDto(book);
        assertThat(this.json.write(dto))
                .isStrictlyEqualToJson("{\"id\":null,\"bookTitle\":\"Война и мир\",\"authorName\":\"Лев\",\"authorLastName\":\"Толстой\",\"genre\":\"роман-эпопея\"}");
    }


    @Test
    public void testDeserializePerson() throws Exception {
        BookDto dto = this.json.read("/book-war.json").getObject();
        assertEquals("Война и мир", dto.getBookTitle());
        assertEquals("Толстой", dto.getAuthorLastName());
    }
}