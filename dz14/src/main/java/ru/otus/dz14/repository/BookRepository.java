package ru.otus.dz14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.otus.dz14.domain.Book;

//import javax.persistence.Query;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAll();

    Book findById(int id);

    void deleteById(int id);
}
