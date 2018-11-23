package ru.otus.dz17.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "books")
public class Book {

    @Id
    private String id;
    @Field("tittle")
    private String tittle;
    private Author author;
    private Genre genre;

    public Book(String tittle, Author author, Genre genre) {
        this.tittle = tittle;
        this.author = author;
        this.genre = genre;
    }

}
