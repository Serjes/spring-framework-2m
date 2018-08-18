package ru.otus.dz10.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.dz10.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Integer> {

    Genre getByName(String name);

    void insert(Genre genre);
}
