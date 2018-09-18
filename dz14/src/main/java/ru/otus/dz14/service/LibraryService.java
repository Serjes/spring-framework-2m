package ru.otus.dz14.service;

public interface LibraryService {

    void addTemplateBook();

    void addBook(String title, String author, String authorLastname, String genre);

    void updateBook(Integer id, String title, String author, String authorLastName, String genre);

    void listBooks();

    void count();

    void delBook(Integer id);

    void printAuthorId(String name, String lastName);

    void listAuthors();
}
