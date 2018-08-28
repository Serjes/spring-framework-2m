package ru.otus.dz12.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz12.domain.Author;
import ru.otus.dz12.domain.Book;
import ru.otus.dz12.domain.Genre;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BookRepositoryJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepositoryJpa;

    @Autowired
    private GenreRepository genreRepositoryJpa;

    @Autowired
    private AuthorRepository authorRepositoryJpa;

    @Test
    public void whenGetById_thenReturnBook(){

//        Author author = new Author("Б.Эккель");
//        authorRepositoryJpa.save(author);
//        Genre genre = new Genre("Информационные технологии");
//        genreRepositoryJpa.save(genre);
//
//        Book book = new Book("Филиософия Java", author, genre);
//        entityManager.persist(book);
//        entityManager.flush();
//
//        Book gotBook = bookRepositoryJpa.findById(1);
//        System.out.println(gotBook.getTittle());
//
//        assertEquals(gotBook.getTittle(), book.getTittle());

    }

}