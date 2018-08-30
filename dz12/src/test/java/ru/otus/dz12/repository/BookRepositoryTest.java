package ru.otus.dz12.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dz12.domain.Author;
import ru.otus.dz12.domain.Book;
import ru.otus.dz12.domain.Genre;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@RunWith(SpringRunner.class)
@DataMongoTest
//@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
//@SpringBootTest
//@EnableMongoRepositories(basePackages = "ru.otus.dz12.repository")
//@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BookRepositoryTest {

    @Autowired
//    private TestEntityManager entityManager;
    private MongoTemplate mongoTemplate;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void whenGetById_thenReturnBook(){

        Author author = new Author("Б.Эккель");
        authorRepository.save(author);
        Genre genre = new Genre("Информационные технологии");
        genreRepository.save(genre);

        Book book = new Book("Филиософия Java", author, genre);
        mongoTemplate.save(book);
//        mongoTemplate.flush();

        List<Book> gotBooks = bookRepository.findAll();//.findById(1);
//        System.out.println(gotBooks.get(0).getTittle());

        assertEquals(gotBooks.get(0).getTittle(), book.getTittle());

    }

}