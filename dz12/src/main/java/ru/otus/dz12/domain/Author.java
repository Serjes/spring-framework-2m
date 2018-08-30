package ru.otus.dz12.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//import javax.persistence.*;
import java.util.Set;

@Document(collection = "authors")
public class Author {

    @Id
    private String id;

    @Field("name")
    private String name;
//    private String firstName;
//    private String secondName;

    private Set<Book> books;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
