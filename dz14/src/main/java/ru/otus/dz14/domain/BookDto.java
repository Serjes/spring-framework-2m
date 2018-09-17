package ru.otus.dz14.domain;

@SuppressWarnings("all")
public class BookDto {

    private Integer id;
    private String bookTitle;
    private String authorName;
    private String authorLastName;
    private String genre;

    public BookDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
