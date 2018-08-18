package ru.otus.dz10.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.dz10.domain.Genre;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ComponentScan("ru.otus.dz10.repository")
@RunWith(SpringRunner.class)
public class GenreRepositoryJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GenreRepository genreRepositoryJpa;

    @Test
    public void whenGetByName_thenReturnGenre(){
        Genre genre = new Genre("Информационные технологии");
        entityManager.persist(genre);
        entityManager.flush();

        Genre gotGenre = genreRepositoryJpa.getByName(genre.getName());

        assertThat(gotGenre.getName())
                .isEqualTo(genre.getName());
    }

}