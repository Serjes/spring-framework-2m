package ru.otus.dz12.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.dz12.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {

    Genre findByName(String name);

}
