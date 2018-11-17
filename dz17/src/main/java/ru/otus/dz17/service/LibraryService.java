package ru.otus.dz17.service;

public interface LibraryService {

    void addTemplateBook();

    void addBook(String name, String author, String authorLastname, String genre);

    void listBooks();

//    void listBooksByAuthorLastName(String authorLastName);

    void count();

    void delBook(int id);

    void printAuthorId(String name, String lastName);

    void listAuthors();
}
