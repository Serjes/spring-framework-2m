package ru.otus.dz14.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

//    private String name;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;

    @OneToMany(mappedBy="author", fetch=FetchType.LAZY, orphanRemoval = true)
    private Set<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //    public Author(String name) {
//        this.name = name;
//    }

    public int getId() {
        return id;
    }

//    public String getName() {
//        return name;
//    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
