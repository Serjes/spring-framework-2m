package ru.otus.dz14.service;

public interface CommentService {

    void add(String content, int book);

    void listByBook(int bookId);

    void listAllPages();
}
