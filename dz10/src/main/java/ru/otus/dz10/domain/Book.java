package ru.otus.dz10.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tittle;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, orphanRemoval = true)
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                '}';
    }
}
