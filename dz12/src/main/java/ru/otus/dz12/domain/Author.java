package ru.otus.dz12.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "authors")
public class Author {

    @Id
    private String id;
//    @Field("name")
//    private String name;
    @Field("firstName")
    private String firstName;
    @Field("lasttName")
    private String lastName;
//    @DBRef
    private List<Book> books = new ArrayList<>();
//    private Set<Book> books;// = new HashSet<>();
//    private Set<Book> books = new HashSet<>();

    public Author() {
//        books = new HashSet<>();
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        books = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

//        public Set<Book> getBooks() {
//        return books;
//    }

//    public void addBook(Book book){
//        books.add(book);
//
//    }
}
