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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dz12.domain.Author;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class AuthorRepositoryTest {

    @Autowired
//    private TestEntityManager entityManager;
    private MongoTemplate mongoTemplate;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void whenGetByName_thenReturnAuthor(){
        Author author = new Author("Брюс", "Эккель");
        mongoTemplate.save(author);

        Author gotAuthor = authorRepository.findByFirstNameAndLastName(author.getFirstName(), author.getLastName());

        assertThat(gotAuthor.getLastName())
                .isEqualTo(author.getLastName());
    }
}