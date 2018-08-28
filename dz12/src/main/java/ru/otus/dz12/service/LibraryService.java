package ru.otus.dz12.service;

public interface LibraryService {

    void addTemplateBook();

    void addBook(String name, String author, String genre);

    void listBooks();

    void count();

    void delBook(int id);

    void printAuthorId(String name);

    void listAuthors();
}
