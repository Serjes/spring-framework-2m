package ru.otus.dz12.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dz12.domain.Author;
import ru.otus.dz12.domain.Book;
import ru.otus.dz12.domain.Genre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@RunWith(SpringRunner.class)
@DataMongoTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
public class AuthorRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void whenGetByName_thenReturnAuthor(){
        Author author = new Author("Брюс", "Эккель");
        mongoTemplate.save(author);

        Author gotAuthor = authorRepository.findByFirstNameAndLastName(author.getFirstName(), author.getLastName());

        assertThat(gotAuthor.getLastName())
                .isEqualTo(author.getLastName());
    }

    @Test
    public void whenGetByAuthorLastName_thenReturnBook(){
        Author author = new Author("Брюс", "Эккель");
        authorRepository.save(author);
        Genre genre = new Genre("Информационные технологии");
        genreRepository.save(genre);
        Book book = new Book("Филиософия Java", author, genre);
        bookRepository.save(book);
        author.getBooks().add(book);
        mongoTemplate.updateFirst(query(where("id").is(author.getId())), update("books", author.getBooks()), Author.class);

        List<Book> gotBooksByAuthorLastName = authorRepository.findAllBooksByAuthorLastName(author.getLastName());

        assertThat(gotBooksByAuthorLastName.get(0).getTittle())
                .isEqualTo(book.getTittle());
    }
}