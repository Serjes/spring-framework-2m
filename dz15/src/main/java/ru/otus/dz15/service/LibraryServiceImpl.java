package ru.otus.dz15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.dz15.domain.Author;
import ru.otus.dz15.domain.Book;
import ru.otus.dz15.domain.Genre;
import ru.otus.dz15.repository.AuthorRepository;
import ru.otus.dz15.repository.BookRepository;
import ru.otus.dz15.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public void addTemplateBook() {
        addBook("Азазель", "Борис","Акунин", "детектив");
    }

    @Override
    public Book addBook(String title, String authorName, String authorLastName, String genreName) {
        Optional<Author> authorOptional = authorRepository.findByFirstNameAndLastName(authorName, authorLastName);
        Author author;
        if (!authorOptional.isPresent()) {
            author = new Author(authorName, authorLastName);
            authorRepository.save(author);
        } else {
            author = authorOptional.get();
        }
        Genre genre = genreRepository.findByName(genreName);
        if (genre == null) {
            genre = new Genre(genreName);
            genreRepository.save(genre);
        }
        Book book = new Book(title, author, genre);
//        bookRepository.save(book);
//        System.out.println("Сохранили новую книжку");
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Integer id, String title, String authorName, String authorLastName, String genreName) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Author author = null;
            Optional<Author> authorOptional = authorRepository.findByFirstNameAndLastName(authorName, authorLastName);
            if (!authorOptional.isPresent()){
                author = new Author(authorName, authorLastName);
                authorRepository.save(author);
            } else {
                author = authorOptional.get();
            }
            Genre genre = null;
            Optional<Genre> genreOptional = Optional.ofNullable(genreRepository.findByName(genreName));
            if (!genreOptional.isPresent()){
                genre = new Genre(genreName);
                genreRepository.save(genre);
            } else {
                genre = genreOptional.get();
            }
            Book book = bookOptional.get();
            book.setTitle(title);
            book.setAuthor(author);
            book.setGenre(genre);
            return bookRepository.save(book);
        }
        return null;

    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> listBooks() {
        return bookRepository.findAll();

    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return bookRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public long countAuthors() {
        return authorRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public long countGenres() {
        return genreRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Book> findBookById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void delBook(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void delAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void delGenre(Integer id) {
        genreRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public void printAuthorId(String name, String lastName) {
        Optional<Author> authorOptional = authorRepository.findByFirstNameAndLastName(name, lastName);
        String authorNotFound = authorOptional.map(a -> "author ID: " + a.getId())
                .orElse("Такой автор не найден");
        System.out.println(authorNotFound);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Genre> listGenres() {
        return genreRepository.findAll();
    }

}
