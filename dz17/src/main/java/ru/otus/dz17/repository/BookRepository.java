package ru.otus.dz17.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.dz17.domain.Book;
//import java.util.Optional;

//public interface BookRepository extends ReactiveMongoRepository<Book, String> {
public interface BookRepository extends ReactiveCrudRepository<Book, String> {

    Flux<Book> findAll();

//    Mono<Book> save(Book book);
}
