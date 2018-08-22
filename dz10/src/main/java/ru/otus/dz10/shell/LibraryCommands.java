package ru.otus.dz10.shell;

//import org.h2.tools.Console;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.dz10.service.CommentService;
import ru.otus.dz10.service.LibraryService;

@ShellComponent
public class LibraryCommands {
    private final LibraryService libraryService;
    private final CommentService commentService;

    public LibraryCommands(LibraryService libraryService, CommentService commentService) {
        this.libraryService = libraryService;
        this.commentService = commentService;
    }

    @ShellMethod("Добавить книгу в библиотеку: add book_name --author author_name --genre genre_name")
    public void add(
            @ShellOption String bookName,
            @ShellOption String author,
            @ShellOption String genre){

        System.out.println("Добавляем книгу: \"" + bookName + "\" " + author + " " + genre);
        libraryService.addBook(bookName, author, genre);
    }

    @ShellMethod("Добавить шаблонную книгу")
//    @ShellMethod("Add one template book")
    public void addtemp() {
        libraryService.addTemplateBook();
        System.out.println("Добавляем книгу: \"Азазель\", Б.Акунин, детектив");
        return;
    }

    @ShellMethod("Добавить комментарий для книги по номеру ID: addc id_book --content text")
    public void addc(
            @ShellOption int id,
            @ShellOption String content
    ){
        System.out.println("Добавляем комментарий: \"" + content + "\"" );
        commentService.add(content, id);
    }

    @ShellMethod("Показать все книги в библиотеке")
    public void list(){
        libraryService.listBooks();
    }

    @ShellMethod("Вывести количество книг в библитеке")
    public void count(){
        libraryService.count();
    }

    @ShellMethod("Удалить книгу по номеру ID: del id_number")
    public void del(
            @ShellOption int id){
        libraryService.delBook(id);
    }

    @ShellMethod("Показать всех авторов книг в библиотеке")
    public void lista(){
        libraryService.listAuthors();
    }

    @ShellMethod("Показать ID автора по имени: showaid author_name")
    public void showaid(
            @ShellOption String name
    ){
        libraryService.printAuthorId(name);
    }

    @ShellMethod("Показать все комментарии по ID книги: listc id_book")
    public void listc(
            @ShellOption int id
    ){
        commentService.listByBook(id);
    }

    @ShellMethod("Показать все комментарии постранично: listcp")
    public void listcp(){
        commentService.listAllPages();
    }
}
