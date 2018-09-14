package ru.otus.dz14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.dz14.domain.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    Genre findByName(String name);

}
