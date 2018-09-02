package ru.otus.dz12.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

    private Set<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //    public Author(String firstName, String lastName) {
//        this.name = name;
//    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //    public String getName() {
//        return name;
//    }

}
