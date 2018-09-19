package ru.otus.dz14.service;

public interface CommentService {

    void add(String content, Integer book);

    void listByBook(Integer bookId);

//    void listAllPages();

//    void updateComment(Integer id, String commentContent, Integer bookId);

    void updateComment(Integer id, String commentContent);
}
