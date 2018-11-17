package ru.otus.dz17.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//import javax.persistence.*;


@Document(collection = "books")
public class Book {

    @Id
    private String id;
    @Field("tittle")
    private String tittle;
    @DBRef
    private Author author;
    @DBRef
    private Genre genre;

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
