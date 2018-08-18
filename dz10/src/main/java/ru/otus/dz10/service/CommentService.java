package ru.otus.dz10.service;

public interface CommentService {

    void add(String content, int book);

    void listByBook(int bookId);
}
