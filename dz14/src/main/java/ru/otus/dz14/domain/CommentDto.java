package ru.otus.dz14.domain;

public class CommentDto {

    private Integer id;
    private String commentContent;
    private String bookTitle;

    public CommentDto() {
    }

    public CommentDto(Integer id, String commentContent, String bookTitle) {
        this.id = id;
        this.commentContent = commentContent;
        this.bookTitle = bookTitle;
    }

//    public CommentDto(Integer id, String commentContent) {
//        this.id = id;
//        this.commentContent = commentContent;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
