package ru.otus.dz12.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//import javax.persistence.*;
import java.util.List;

@Document(collection = "books")
public class Book {

    @Id
    private String id;
    @Field("tittle")
    private String tittle;
    //@Field("author")
    @DBRef
    private Author author;
    //@Field("genre")
    @DBRef
    private Genre genre;
    @DBRef
    private List<Comment> comments;

    public Book() {
    }

    public Book(String tittle, Author author, Genre genre) {
        this.tittle = tittle;
        this.author = author;
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getTittle() {
        return tittle;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "tittle='" + tittle + '\'' +
                '}';
    }
}
