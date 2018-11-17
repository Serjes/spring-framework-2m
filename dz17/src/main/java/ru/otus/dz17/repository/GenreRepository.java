package ru.otus.dz17.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.dz17.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {

    Genre findByName(String name);

}
