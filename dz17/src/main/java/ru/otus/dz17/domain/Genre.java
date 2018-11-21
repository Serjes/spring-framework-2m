package ru.otus.dz17.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "genres")
public class Genre {

    @Id
    private String id;
    @Field("name")
    private String name;

    public Genre(String name) {
        this.name = name;
    }

}
