package ru.otus.dz17.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "authors")
public class Author {

    @Id
    private String id;
    @Field("firstName")
    private String firstName;
    @Field("lasttName")
    private String lastName;
//    @DBRef
//    private List<Book> books = new ArrayList<>();

//    public Author() {
//    }
//
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public List<Book> getBooks() {
//        return books;
//    }

}
