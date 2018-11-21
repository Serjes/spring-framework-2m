package ru.otus.dz17.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

//import javax.persistence.*;

@ToString
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Document(collection = "genres")
public class Genre {

    @Id
    private String id;
    @Field("name")
    private String name;
//    @DBRef
//    private Set<Book> books = new HashSet<>();

//    public Genre() {
//    }
//
    public Genre(String name) {
        this.name = name;
    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getId() {
//        return id;
//    }
}
