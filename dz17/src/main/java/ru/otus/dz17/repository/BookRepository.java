package ru.otus.dz17.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.dz17.domain.Book;

public interface BookRepository extends ReactiveCrudRepository<Book, String> {

    Flux<Book> findAll();

    Mono<Void> deleteById(String id);

}
