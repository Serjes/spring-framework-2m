package ru.otus.dz10.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz10.domain.Author;
import ru.otus.dz10.domain.Book;
import ru.otus.dz10.domain.Comment;
import ru.otus.dz10.domain.Genre;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan("ru.otus.dz10.repository")
@RunWith(SpringRunner.class)
public class CommentRepositoryJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CommentRepository commentRepositoryJpa;

    @Test
    public void whenGetAllByBook_thenReturnComment(){

        Author author = new Author("Б.Эккель");
        entityManager.persist(author);
        Genre genre = new Genre("Информационные технологии");
        entityManager.persist(genre);
        Book book = new Book("Филиософия Java", author, genre);
        entityManager.persist(book);

        Comment comment = new Comment("Написана профессиональным языком. Много кода.", book);
        entityManager.persist(comment);
        entityManager.flush();

        ArrayList<Comment> gotComments = (ArrayList<Comment>) commentRepositoryJpa.findAllByBook(book);
        assertThat(gotComments.get(0).getContent())
                .isEqualTo(comment.getContent());
    }
}