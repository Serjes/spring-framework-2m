package ru.otus.dz17.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz17.domain.Author;
import ru.otus.dz17.domain.Book;
import ru.otus.dz17.domain.Genre;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@RunWith(SpringRunner.class)
@DataMongoTest
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
public class BookRepositoryTest {

    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void whenGet_thenReturnBook(){

        Author author = new Author("Брюс", "Эккель");
        authorRepository.save(author).block();
        Genre genre = new Genre("Информационные технологии");
        genreRepository.save(genre).block();

        Book book = new Book("Филиософия Java", author, genre);
        mongoTemplate.save(book).block();

        Book gotBooks = bookRepository.findAll().blockFirst();

        assertEquals(gotBooks.getTittle(), book.getTittle());

    }

}