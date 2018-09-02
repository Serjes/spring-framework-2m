package ru.otus.dz12.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.dz12.domain.Author;
import ru.otus.dz12.domain.Book;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.*;

public class AuthorRepositoryCustomImpl implements AuthorRepositoryCustom{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Book> findAllBooksByAuthorLastName(String lastName) {
        List<Author> authors = mongoTemplate.find(query(where("lastName").is(lastName)), Author.class);
        return authors.get(0).getBooks();
    }

    @Override
    public void addBook(Author author, Book book) {
        author.getBooks().add(book);
        mongoTemplate.updateFirst(query(where("lastName").is(author.getLastName())),
                update("books", author.getBooks()), Author.class);
    }
}
