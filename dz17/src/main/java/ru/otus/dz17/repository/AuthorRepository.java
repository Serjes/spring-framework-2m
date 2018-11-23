package ru.otus.dz17.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.dz17.domain.Author;

public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {

    Mono<Author> findByFirstNameAndLastName(String name, String lastName);

    Flux<Author> findAll();
}
