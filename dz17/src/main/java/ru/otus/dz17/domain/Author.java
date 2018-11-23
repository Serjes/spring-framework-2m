package ru.otus.dz17.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
