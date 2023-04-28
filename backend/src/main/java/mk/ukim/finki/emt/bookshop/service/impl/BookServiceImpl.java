package mk.ukim.finki.emt.bookshop.service.impl;

import mk.ukim.finki.emt.bookshop.model.Author;
import mk.ukim.finki.emt.bookshop.model.Book;
import mk.ukim.finki.emt.bookshop.model.dto.BookDto;
import mk.ukim.finki.emt.bookshop.model.enumerations.Category;
import mk.ukim.finki.emt.bookshop.model.exceptions.AuthorWithIdNotFound;
import mk.ukim.finki.emt.bookshop.model.exceptions.BookWithIdNotFound;
import mk.ukim.finki.emt.bookshop.model.exceptions.NoMoreAvailableCopiesException;
import mk.ukim.finki.emt.bookshop.repository.AuthorRepository;
import mk.ukim.finki.emt.bookshop.repository.BookRepository;
import mk.ukim.finki.emt.bookshop.service.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book=this.findById(id).orElseThrow(() -> new BookWithIdNotFound(id));
        Author author=this.authorRepository.findById(authorId).orElseThrow(() -> new AuthorWithIdNotFound(authorId));
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);
        book.setName(name);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id,BookDto bookDto) {
        Book book=this.findById(id).orElseThrow(() -> new BookWithIdNotFound(id));
        Author author=this.authorRepository.findById(bookDto.getAuthorId()).orElseThrow(() -> new AuthorWithIdNotFound(bookDto.getAuthorId()));
        book.setAuthor(author);
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setName(book.getName());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void decreaseAvailableCopies(Long id) {
        Book book=this.findById(id).orElseThrow(() -> new BookWithIdNotFound(id));
        if (book.getAvailableCopies() > 0){
            Integer copies=book.getAvailableCopies() - 1;
            book.setAvailableCopies(copies);
            this.bookRepository.save(book);
        }
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies) {
        Author author=this.authorRepository.findById(authorId).orElseThrow(()-> new AuthorWithIdNotFound(authorId));
        Book book=new Book(name,category,author,availableCopies);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> save(@NotNull BookDto bookDto) {
        Author author=this.authorRepository.findById(bookDto.getAuthorId()).orElseThrow(() -> new AuthorWithIdNotFound(bookDto.getAuthorId()));
        Book book=new Book(bookDto.getName(),bookDto.getCategory(),author, bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }



    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

}
