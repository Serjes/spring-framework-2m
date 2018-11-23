package ru.otus.dz17.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.otus.dz17.domain.Genre;

public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {

    Mono<Genre> findByName(String name);

}
