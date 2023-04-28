package mk.ukim.finki.emt.bookshop.service;

import mk.ukim.finki.emt.bookshop.model.Book;
import mk.ukim.finki.emt.bookshop.model.dto.BookDto;
import mk.ukim.finki.emt.bookshop.model.enumerations.Category;
import mk.ukim.finki.emt.bookshop.model.exceptions.NoMoreAvailableCopiesException;

import java.util.List;
import java.util.Optional;

public interface BookService {

     List<Book> findAll();

     Optional<Book> findById(Long id);

     Optional<Book> findByName(String name);

     Optional<Book> edit(Long id, String  name, Category category,Long authorId,Integer availableCopies);

     Optional<Book> edit(Long id, BookDto bookDto);

     void decreaseAvailableCopies(Long id);

     Optional<Book> save(String name, Category category, Long author, Integer availableCopies);

     Optional<Book> save(BookDto bookDto);

     void deleteById(Long id);
     ;
}
