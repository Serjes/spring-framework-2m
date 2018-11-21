package ru.otus.dz17.dto;

import lombok.*;
import ru.otus.dz17.domain.Book;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuppressWarnings("all")
public class BookDto {

    private String id;
    private String bookTitle;
    private String authorName;
    private String authorLastName;
    private String genre;

//    public BookDto() {
//    }
//
//    public BookDto(Integer id, String bookTitle, String authorName, String authorLastName, String genre) {
//        this.id = id;
//        this.bookTitle = bookTitle;
//        this.authorName = authorName;
//        this.authorLastName = authorLastName;
//        this.genre = genre;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public String getBookTitle() {
//        return bookTitle;
//    }
//
//    public String getAuthorName() {
//        return authorName;
//    }
//
//    public String getAuthorLastName() {
//        return authorLastName;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public void setBookTitle(String bookTitle) {
//        this.bookTitle = bookTitle;
//    }
//
//    public void setAuthorName(String authorName) {
//        this.authorName = authorName;
//    }
//
//    public void setAuthorLastName(String authorLastName) {
//        this.authorLastName = authorLastName;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }

    public static BookDto toDto(Book book){
//        System.out.println(book.getId() + book.getTittle());
//        System.out.println(book.toString());
//        System.out.println(book.getId() + book.getTittle() +  book.getAuthor().getFirstName() +
//                book.getAuthor().getLastName() + book.getGenre().getName());
        return new BookDto(book.getId(), book.getTittle(), book.getAuthor().getFirstName(),
                book.getAuthor().getLastName(), book.getGenre().getName());
//        return new BookDto(book.getId(), book.getTittle(), "aaaaaaaa",
//                "bbbbbbbb", "cccccccc");
    }
}
