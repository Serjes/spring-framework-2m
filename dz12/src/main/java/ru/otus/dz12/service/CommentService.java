package ru.otus.dz12.service;

public interface CommentService {

    void add(String content, int book);

    void listByBook(int bookId);

    void listAllPages();
}
