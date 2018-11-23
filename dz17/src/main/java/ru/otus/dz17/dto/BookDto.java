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

    public static BookDto toDto(Book book){
        return new BookDto(book.getId(), book.getTittle(), book.getAuthor().getFirstName(),
                book.getAuthor().getLastName(), book.getGenre().getName());
    }
}
