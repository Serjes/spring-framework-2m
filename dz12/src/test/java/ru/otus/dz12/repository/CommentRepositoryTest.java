package ru.otus.dz12.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dz12.domain.Author;
import ru.otus.dz12.domain.Book;
import ru.otus.dz12.domain.Comment;
import ru.otus.dz12.domain.Genre;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

//@Ignore
@RunWith(SpringRunner.class)
@DataMongoTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
//@DataJpaTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CommentRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void whenGetAllByBook_thenReturnComment(){

        Author author = new Author("Б.Эккель");
        mongoTemplate.save(author);
        Genre genre = new Genre("Информационные технологии");
        mongoTemplate.save(genre);
        Book book = new Book("Филиософия Java", author, genre);
        mongoTemplate.save(book);

        Comment comment = new Comment("Написана профессиональным языком. Много кода.", book);
        mongoTemplate.save(comment);
//        entityManager.flush();

        ArrayList<Comment> gotComments = (ArrayList<Comment>) commentRepository.findAllByBook(book);
        assertThat(gotComments.get(0).getContent())
                .isEqualTo(comment.getContent());
    }
}