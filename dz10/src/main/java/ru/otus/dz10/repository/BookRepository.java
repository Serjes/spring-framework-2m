package ru.otus.dz10.repository;

import org.springframework.data.repository.CrudRepository;
import ru.otus.dz10.domain.Book;

//import javax.persistence.Query;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAll();

//    long count();

    Book findById(int id);

    void deleteById(int id);
}
