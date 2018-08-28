package ru.otus.dz12.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//import javax.persistence.*;
import java.util.Set;

@Document(collection = "genres")
public class Genre {

    @Id
    private String id;

    @Field("name")
    private String name;
    private Set<Book> books;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
