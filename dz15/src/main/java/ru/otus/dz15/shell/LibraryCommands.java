package ru.otus.dz15.shell;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.dz15.domain.Author;
import ru.otus.dz15.domain.Book;
import ru.otus.dz15.service.LibraryService;

import java.util.List;

@Ignore
@ShellComponent
public class LibraryCommands {
    private final LibraryService libraryService;

    public LibraryCommands(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @ShellMethod("Добавить книгу в библиотеку: add book_title --author-name author_name author_last_name --genre genre_name")
    public void add(
            @ShellOption String bookTitle,
            @ShellOption String authorName,
            @ShellOption String authorLastName,
            @ShellOption String genre){

        System.out.println("Добавляем книгу: \"" + bookTitle + "\" " + authorName + " " + authorLastName + " " + genre);
        libraryService.addBook(bookTitle, authorName, authorLastName, genre);
    }

    @ShellMethod("Добавить шаблонную книгу")
    public void addtemp() {
        libraryService.addTemplateBook();
        System.out.println("Добавляем книгу: \"Азазель\", Акунин, детектив");
        return;
    }

    @ShellMethod("Показать все книги в библиотеке")
    public void list(){
        List<Book> books = libraryService.listBooks();
        for (Book book : books) {
            System.out.println("ID:" + book.getId() + " название: \"" + book.getTitle() + "\", автор: "
                    + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName()
                    + ", жанр: " + book.getGenre().getName());
        }
    }

    @ShellMethod("Вывести количество книг в библитеке")
    public void count(){
        long number = libraryService.count();
        System.out.println(number);
    }

    @ShellMethod("Удалить книгу по номеру ID: del id_number")
    public void del(
            @ShellOption int id){
        libraryService.delBook(id);
    }

    @ShellMethod("Показать всех авторов книг в библиотеке")
    public void lista(){
        List<Author> authors = libraryService.listAuthors();
        for (Author author : authors) {
            System.out.println("ID:" + author.getId() + " автор: " + author.getFirstName() + " " + author.getLastName());
        }
    }

    @ShellMethod("Показать ID автора по имени: showaid name last_name")
    public void showaid(
            @ShellOption String name,
            @ShellOption String lastName
    ){
        libraryService.printAuthorId(name, lastName);
    }

}
